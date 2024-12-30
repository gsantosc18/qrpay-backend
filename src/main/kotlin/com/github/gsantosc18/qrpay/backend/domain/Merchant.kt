package com.github.gsantosc18.qrpay.backend.domain

import java.time.LocalDateTime

data class Merchant(
    val id: Long?,
    val name: String,
    val city: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    init {
        if (name.length > 25) {
            throw IllegalArgumentException("Name not be great than 25 characters")
        }
    }
}
