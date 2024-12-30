package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.repository.entity.InternalConfigEntity
import java.time.LocalDateTime

data class InternalConfigDTO(
    val id: Long?,
    val imageWidth: Int,
    val imageHeight: Int,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun from(internalConfigEntity: InternalConfigEntity): InternalConfigDTO =
            with(internalConfigEntity) {
                InternalConfigDTO(
                    id = id,
                    imageWidth = imageWidth,
                    imageHeight = imageHeight,
                    updatedAt = updatedAt
                )
            }
    }
}