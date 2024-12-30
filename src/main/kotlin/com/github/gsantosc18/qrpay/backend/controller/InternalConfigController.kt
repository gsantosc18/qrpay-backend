package com.github.gsantosc18.qrpay.backend.controller

import com.github.gsantosc18.qrpay.backend.dto.InternalConfigDTO
import com.github.gsantosc18.qrpay.backend.dto.UpdateInternalConfigDTO
import com.github.gsantosc18.qrpay.backend.service.InternalConfigService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/config")
class InternalConfigController(
    private val internalConfigService: InternalConfigService
) {
    @GetMapping
    fun view(): ResponseEntity<InternalConfigDTO> =
        ResponseEntity.ok(internalConfigService.currentConfig())

    @PutMapping
    fun update(@RequestBody updateInternalConfigDTO: UpdateInternalConfigDTO): ResponseEntity<Any> {
        internalConfigService.updateConfig(updateInternalConfigDTO)
        return ResponseEntity.ok().build()
    }
}