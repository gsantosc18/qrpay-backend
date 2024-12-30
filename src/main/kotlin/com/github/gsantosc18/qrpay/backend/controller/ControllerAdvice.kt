package com.github.gsantosc18.qrpay.backend.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Component
@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalHandle(exception: IllegalArgumentException): ResponseEntity<Map<String, String?>> =
        ResponseEntity.badRequest()
            .body(mapOf(
                "error" to exception.message
            ))
}