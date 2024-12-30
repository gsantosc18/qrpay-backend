package com.github.gsantosc18.qrpay.backend.service

import com.github.gsantosc18.qrpay.backend.dto.CreatePixDTO
import com.github.gsantosc18.qrpay.backend.dto.PixDTO
import java.awt.image.BufferedImage
import java.math.BigDecimal

interface PixService {
    fun create(createPixDTO: CreatePixDTO)
    fun list(): List<PixDTO>
    fun generateQrCode(id: Long, amount: BigDecimal): BufferedImage
}