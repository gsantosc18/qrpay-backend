package com.github.gsantosc18.qrpay.backend.repository

import com.github.gsantosc18.qrpay.backend.repository.entity.PixEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PixRepository: JpaRepository<PixEntity, Long>
