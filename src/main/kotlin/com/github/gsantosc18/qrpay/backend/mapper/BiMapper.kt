package com.github.gsantosc18.qrpay.backend.mapper

interface BiMapper<T, V> {
    fun toEntity(obj: T): V
    fun toDomain(obj: V): T
}