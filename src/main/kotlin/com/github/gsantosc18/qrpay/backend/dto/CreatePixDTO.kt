package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.domain.Pix
import com.github.gsantosc18.qrpay.backend.domain.enums.PixKeyType

data class CreatePixDTO(
    val key: String,
    val type: PixKeyType,
    val merchantId: Long
) {
    fun toDomain(): Pix =
        Pix(
            id = null,
            key = key,
            type = type,
            merchantId = merchantId,
            createdAt = null,
            updatedAt = null
        )
}