package com.github.gsantosc18.qrpay.backend.service.impl

import com.github.gsantosc18.qrpay.backend.dto.InternalConfigDTO
import com.github.gsantosc18.qrpay.backend.dto.UpdateInternalConfigDTO
import com.github.gsantosc18.qrpay.backend.repository.InternalConfigRepository
import com.github.gsantosc18.qrpay.backend.service.InternalConfigService
import org.springframework.stereotype.Service

@Service
class InternalConfigServiceImpl(
    private val internalConfigRepository: InternalConfigRepository
): InternalConfigService {
    override fun updateConfig(updateInternalConfigDTO: UpdateInternalConfigDTO) {
        updateInternalConfigDTO.toEntity()
            .also(internalConfigRepository::save)
    }

    override fun currentConfig(): InternalConfigDTO? =
        internalConfigRepository.findFirstByOrderByIdDesc()
            ?.let(InternalConfigDTO::from)
}