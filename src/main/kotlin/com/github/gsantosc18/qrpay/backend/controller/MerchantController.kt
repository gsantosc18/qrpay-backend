package com.github.gsantosc18.qrpay.backend.controller

import com.github.gsantosc18.qrpay.backend.dto.CreateMerchantDTO
import com.github.gsantosc18.qrpay.backend.dto.MerchantDTO
import com.github.gsantosc18.qrpay.backend.service.MerchantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant")
class MerchantController(
    private val merchantService: MerchantService
) {
    @PostMapping
    fun create(@RequestBody dto: CreateMerchantDTO): ResponseEntity<Unit> {
        merchantService.create(dto)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun list(): ResponseEntity<List<MerchantDTO>> =
        ResponseEntity.ok(merchantService.list())
}