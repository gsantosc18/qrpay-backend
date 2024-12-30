package com.github.gsantosc18.qrpay.backend.dto

import com.github.gsantosc18.qrpay.backend.repository.entity.InternalConfigEntity

data class UpdateInternalConfigDTO(
    val imageWidth: Int,
    val imageHeight: Int
) {
    fun toEntity(): InternalConfigEntity =
        InternalConfigEntity(
            id = null,
            imageWidth = imageWidth,
            imageHeight = imageHeight,
            updatedAt = null
        )
}
