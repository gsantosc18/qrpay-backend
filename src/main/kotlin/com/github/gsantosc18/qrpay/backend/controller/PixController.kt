package com.github.gsantosc18.qrpay.backend.controller

import com.github.gsantosc18.qrpay.backend.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.backend.dto.PixDTO
import com.github.gsantosc18.qrpay.backend.service.PixService
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.math.BigDecimal
import javax.imageio.ImageIO
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pix")
class PixController(
    private val pixService: PixService
) {
    @PostMapping
    fun create(@RequestBody dto: CreatePixDTO): ResponseEntity<Unit> {
        pixService.create(dto)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun list(): ResponseEntity<List<PixDTO>> =
        ResponseEntity.ok(pixService.list())

    @GetMapping("/{id}/qrcode/{amount}")
    fun generateQrCode(@PathVariable("id") id: Long, @PathVariable("amount") amount: BigDecimal): ResponseEntity<Any> {
        val qrCode = pixService.generateQrCode(id, amount)
        val baos = ByteArrayOutputStream()
        return try {
            ImageIO.write(qrCode, "png", baos)
            ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/png")
                .body(baos.toByteArray())
        } catch (ioex: IOException){
            ResponseEntity.internalServerError()
                .body(mapOf("error" to ioex.message))
        } finally {
            baos.close()
        }
    }
}