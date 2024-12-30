package com.github.gsantosc18.qrpay.backend.domain.validations

interface Validation {
    fun validate(value: String): Boolean
}