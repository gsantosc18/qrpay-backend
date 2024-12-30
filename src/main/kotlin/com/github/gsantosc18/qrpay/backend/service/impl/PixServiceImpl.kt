package com.github.gsantosc18.qrpay.backend.service.impl

import com.github.gsantosc18.qrpay.backend.domain.Pix
import com.github.gsantosc18.qrpay.backend.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.backend.dto.PixDTO
import com.github.gsantosc18.qrpay.backend.mapper.BiMapper
import com.github.gsantosc18.qrpay.backend.mapper.PixMapper
import com.github.gsantosc18.qrpay.backend.repository.InternalConfigRepository
import com.github.gsantosc18.qrpay.backend.repository.MerchantRepository
import com.github.gsantosc18.qrpay.backend.repository.PixRepository
import com.github.gsantosc18.qrpay.backend.repository.entity.PixEntity
import com.github.gsantosc18.qrpay.backend.service.PixService
import com.github.gsantosc18.qrpay.backend.sharted.IMAGE_HEIGHT_DEFAULT
import com.github.gsantosc18.qrpay.backend.sharted.IMAGE_WIDTH_DEFAULT
import com.github.gsantosc18.qrpay.service.PixCodeService
import com.github.gsantosc18.qrpay.service.QRCodeService
import java.awt.image.BufferedImage
import java.math.BigDecimal
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import com.github.gsantosc18.qrpay.dto.PixDTO as QrPayDTO

@Service
class PixServiceImpl(
    private val mapper: BiMapper<Pix, PixEntity> = PixMapper,
    private val repository: PixRepository,
    private val merchantRepository: MerchantRepository,
    private val internalConfigRepository: InternalConfigRepository
): PixService {
    override fun create(createPixDTO: CreatePixDTO) {
        createPixDTO.toDomain()
            .let(mapper::toEntity)
            .also(repository::save)
    }

    override fun list(): List<PixDTO> =
        repository.findAll()
            .map(mapper::toDomain)
            .map(PixDTO::from)

    override fun generateQrCode(id: Long, amount: BigDecimal): BufferedImage {
        val pix = repository.findByIdOrNull(id)
        requireNotNull(pix) { "Pix $id not found" }
        val merchant = merchantRepository.findByIdOrNull(pix.merchantId)
        requireNotNull(merchant) { "Merchant ${pix.merchantId} not found" }
        val config = internalConfigRepository.findFirstByOrderByIdDesc()
        val code = PixCodeService.generate(
            QrPayDTO(
                key = pix.key,
                amount = amount,
                merchantName = merchant.name,
                merchantCity = merchant.city
            )
        )
        return QRCodeService.generate(
            code = code,
            width = config?.imageWidth ?: IMAGE_WIDTH_DEFAULT,
            height = config?.imageHeight ?: IMAGE_HEIGHT_DEFAULT
        )
    }
}