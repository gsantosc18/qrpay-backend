package com.github.gsantosc18.qrpay.backend.domain.validations

import java.util.UUID

object EmailValidation: Validation {
    override fun validate(value: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        return value.matches(Regex(emailRegex))
    }
}

object PhoneNumberValidation: Validation {
    override fun validate(value: String): Boolean {
        val phoneRegex = "^\\+55[1-9]{2}[9]?[0-9]{4}[0-9]{4}$"
        return value.matches(Regex(phoneRegex))
    }
}

object DocumentValidation: Validation {
    override fun validate(value: String): Boolean {
        if (value.any{ it.isDigit().not() }) return false

        val cleanedCPF = value.replace("[^0-9]".toRegex(), "")

        if (cleanedCPF.length != 11) return false

        if (cleanedCPF.all { it == cleanedCPF[0] }) return false

        val firstDigit = calculateDigit(cleanedCPF.substring(0, 9), 10)
        val secondDigit = calculateDigit(cleanedCPF.substring(0, 10), 11)

        return cleanedCPF[9] == firstDigit && cleanedCPF[10] == secondDigit
    }

    private fun calculateDigit(cpf: String, weight: Int): Char {
        var sum = 0
        var weightCounter = weight

        for (char in cpf) {
            sum += (char.toString().toInt() * weightCounter)
            weightCounter--
        }

        val remainder = sum % 11
        return if (remainder < 2) '0' else (11 - remainder).toString()[0]
    }
}

object RandomValidation: Validation {
    override fun validate(value: String): Boolean {
        return try {
            UUID.fromString(value)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}
