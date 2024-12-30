package com.github.gsantosc18.qrpay.backend.domain

import com.github.gsantosc18.qrpay.backend.domain.enums.PixKeyType
import java.time.LocalDateTime

data class Pix(
    val id: Long?,
    val key: String,
    val type: PixKeyType,
    val merchantId: Long,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    init {
        if (type.validation.validate(key).not()) {
            throw IllegalArgumentException("Pix key ${type.name} is invalid")
        }
    }
}