package com.github.gsantosc18.qrpay.backend.service.impl

import com.github.gsantosc18.qrpay.backend.domain.Merchant
import com.github.gsantosc18.qrpay.backend.dto.CreateMerchantDTO
import com.github.gsantosc18.qrpay.backend.dto.MerchantDTO
import com.github.gsantosc18.qrpay.backend.mapper.BiMapper
import com.github.gsantosc18.qrpay.backend.mapper.MerchantMapper
import com.github.gsantosc18.qrpay.backend.repository.MerchantRepository
import com.github.gsantosc18.qrpay.backend.repository.entity.MerchantEntity
import com.github.gsantosc18.qrpay.backend.service.MerchantService
import org.springframework.stereotype.Service

@Service
class MerchantServiceImpl(
    private val mapper: BiMapper<Merchant, MerchantEntity> = MerchantMapper,
    private val repository: MerchantRepository
): MerchantService {
    override fun create(createMerchantDTO: CreateMerchantDTO) {
        createMerchantDTO.toDomain()
            .let(mapper::toEntity)
            .also(repository::save)
    }

    override fun list(): List<MerchantDTO> =
        repository.findAll()
            .map(mapper::toDomain)
            .map(MerchantDTO::from)
}