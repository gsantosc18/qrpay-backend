package com.github.gsantosc18.qrpay.backend.domain.validations

object EmailValidation: Validation {
    override fun validate(value: String): Boolean {
        return true
    }
}

object PhoneNumberValidation: Validation {
    override fun validate(value: String): Boolean {
        TODO("Not yet implemented")
    }
}

object DocumentValidation: Validation {
    override fun validate(value: String): Boolean {
        TODO("Not yet implemented")
    }
}

object RandomValidation: Validation {
    override fun validate(value: String): Boolean {
        TODO("Not yet implemented")
    }
}
