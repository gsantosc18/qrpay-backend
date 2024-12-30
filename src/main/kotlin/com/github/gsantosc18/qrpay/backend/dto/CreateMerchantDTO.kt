package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.domain.Merchant

data class CreateMerchantDTO(
    val name: String,
    val city: String
) {
    fun toDomain(): Merchant = Merchant(
        id = null,
        name = name,
        city = city,
        createdAt = null,
        updatedAt = null
    )
}
