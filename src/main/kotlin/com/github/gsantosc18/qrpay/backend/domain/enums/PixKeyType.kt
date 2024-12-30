package com.github.gsantosc18.qrpay.backend.domain.enums

import com.github.gsantosc18.qrpay.backend.domain.validations.DocumentValidation
import com.github.gsantosc18.qrpay.backend.domain.validations.EmailValidation
import com.github.gsantosc18.qrpay.backend.domain.validations.PhoneNumberValidation
import com.github.gsantosc18.qrpay.backend.domain.validations.RandomValidation
import com.github.gsantosc18.qrpay.backend.domain.validations.Validation

enum class PixKeyType(val validation: Validation) {
    PHONE_NUMBER(PhoneNumberValidation),
    EMAIL(EmailValidation),
    DOCUMENT(DocumentValidation),
    RANDOM(RandomValidation)
}