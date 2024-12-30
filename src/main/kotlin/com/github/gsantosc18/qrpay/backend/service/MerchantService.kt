package com.github.gsantosc18.qrpay.backend.service

import com.github.gsantosc18.qrpay.backend.dto.CreateMerchantDTO
import com.github.gsantosc18.qrpay.backend.dto.MerchantDTO

interface MerchantService {
    fun create(createMerchantDTO: CreateMerchantDTO)
    fun list(): List<MerchantDTO>
}