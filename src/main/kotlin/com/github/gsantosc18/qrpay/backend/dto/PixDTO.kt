package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.domain.Pix
import com.github.gsantosc18.qrpay.backend.domain.enums.PixKeyType
import java.time.LocalDateTime

data class PixDTO(
    val id: Long?,
    val key: String,
    val type: PixKeyType,
    val merchant: Long,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {
    companion object {
        fun from(pix: Pix): PixDTO =
            with(pix) {
                PixDTO(
                    id = id,
                    key = key,
                    type = type,
                    merchant = merchantId,
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }
}
