package com.github.gsantosc18.qrpay.backend.domain.validations

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ValidationsTest {
    @ParameterizedTest(name = "{0}")
    @CsvSource(
        "example@example.com,true",
        "user.name+tag+sorting@example.com,true",
        "user@subdomain.example.com,true",
        "invalid-email@.com,false",
        "invalid-email@com,false",
        "invalid-email@com.,false",
        "invalid-email@.com.,false"
    )
    fun `Validate email`(email: String, valid: Boolean) {
        val validation = EmailValidation.validate(email)
        if (valid) {
            assert(validation)
        } else {
            assert(!validation)
        }
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource(
        "+5511912345678,true",
        "+5521987654321,true",
        "+55(11)91234-5678,false",
        "+55111234-5678,false",
        "1191234-5678,false",
        "+551191234-567,false",
        "+551191234-56789,false",
        "+5511912345678,true",
        "+551191234.5678,false"
    )
    fun `validate phone number`(phone: String, valid: Boolean) {
        val validation = PhoneNumberValidation.validate(phone)
        if (valid) {
            assert(validation)
        } else {
            assert(!validation)
        }
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource(
        "12345678909,true",
        "12345678900,false",
        "111.444.777-35,false",
        "11144477735,true",
        "000.000.000-00,false",
        "12345678909,true",
        "123.456.789-0,false",
        "123.456.789-099,false"
    )
    fun `Validate cpf`(cpf: String, valid: Boolean) {
        val validation = DocumentValidation.validate(cpf)
        if (valid) {
            assert(validation)
        } else {
            assert(!validation)
        }
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource(
        "123e4567-e89b-12d3-a456-426614174000,true",
        "123e4567-e89b-12d3-a456-42661417400Z,false",
        "123e4567-e89b-12d3-a456-42661417400,true",
        "123e4567-e89b-12d3-a456-4266141740000,false",
        "invalid-uuid-string,false"
    )
    fun `Validate random`(random: String, valid: Boolean) {
        val validation = RandomValidation.validate(random)
        if (valid) {
            assert(validation)
        } else {
            assert(!validation)
        }
    }
}
