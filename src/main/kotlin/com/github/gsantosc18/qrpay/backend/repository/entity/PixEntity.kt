package com.github.gsantosc18.qrpay.backend.repository.entity

import com.github.gsantosc18.qrpay.backend.domain.enums.PixKeyType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "pix")
@EntityListeners(AuditingEntityListener::class)
data class PixEntity(
    @Id @GeneratedValue(strategy = AUTO)
    val id: Long? = null,
    @Column(name = "pix_key")
    val key: String,
    @Enumerated(STRING)
    val type: PixKeyType,
    val merchantId: Long,
    @CreatedDate
    var createdAt: LocalDateTime? = null,
    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
)
