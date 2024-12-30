package com.github.gsantosc18.qrpay.backend.service

import com.github.gsantosc18.qrpay.backend.dto.InternalConfigDTO
import com.github.gsantosc18.qrpay.backend.dto.UpdateInternalConfigDTO

interface InternalConfigService {
    fun updateConfig(updateInternalConfigDTO: UpdateInternalConfigDTO)
    fun currentConfig(): InternalConfigDTO?
}