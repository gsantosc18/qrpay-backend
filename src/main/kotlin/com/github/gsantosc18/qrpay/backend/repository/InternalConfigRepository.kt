package com.github.gsantosc18.qrpay.backend.repository

import com.github.gsantosc18.qrpay.backend.repository.entity.InternalConfigEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InternalConfigRepository: JpaRepository<InternalConfigEntity, Long> {
    fun findFirstByOrderByIdDesc(): InternalConfigEntity?
}
