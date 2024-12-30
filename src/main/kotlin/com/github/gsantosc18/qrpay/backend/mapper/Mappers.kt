package com.github.gsantosc18.qrpay.backend.mapper

import com.github.gsantosc18.qrpay.backend.domain.Merchant
import com.github.gsantosc18.qrpay.backend.domain.Pix
import com.github.gsantosc18.qrpay.backend.repository.entity.MerchantEntity
import com.github.gsantosc18.qrpay.backend.repository.entity.PixEntity

object MerchantMapper: BiMapper<Merchant, MerchantEntity> {
    override fun toEntity(obj: Merchant): MerchantEntity =
        with(obj) {
            MerchantEntity(
                id = null,
                name = name,
                city = city,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }

    override fun toDomain(obj: MerchantEntity): Merchant =
        with(obj) {
            Merchant(
                id = id,
                name = name,
                city = city,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }
}

object PixMapper: BiMapper<Pix, PixEntity> {
    override fun toEntity(obj: Pix): PixEntity =
        with(obj) {
            PixEntity(
                id = id,
                key = key,
                type = type,
                merchantId = merchantId,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }

    override fun toDomain(obj: PixEntity): Pix =
        with(obj) {
            Pix(
                id = id,
                key = key,
                type = type,
                merchantId = merchantId,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }
}
