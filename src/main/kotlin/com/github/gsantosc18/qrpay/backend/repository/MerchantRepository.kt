package com.github.gsantosc18.qrpay.backend.repository

import com.github.gsantosc18.qrpay.backend.repository.entity.MerchantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository: JpaRepository<MerchantEntity, Long>