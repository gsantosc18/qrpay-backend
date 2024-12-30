package com.github.gsantosc18.qrpay.backend.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "internal_config")
@EntityListeners(AuditingEntityListener::class)
data class InternalConfigEntity(
    @Id @GeneratedValue(strategy = AUTO)
    val id: Long?,
    val imageWidth: Int,
    val imageHeight: Int,
    @LastModifiedDate
    var updatedAt: LocalDateTime?
)
