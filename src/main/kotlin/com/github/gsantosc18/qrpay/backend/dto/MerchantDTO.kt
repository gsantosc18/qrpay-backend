package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.domain.Merchant
import java.time.LocalDateTime

data class MerchantDTO(
    val id: Long? = null,
    val name: String,
    val city: String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {


    companion object {
        fun from(merchant: Merchant): MerchantDTO =
            with(merchant) {
                MerchantDTO(
                    id = id,
                    name = name,
                    city = city,
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }
}
