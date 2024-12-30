package com.github.gsantosc18.qrpay.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class QrpayBackendApplication

fun main(args: Array<String>) {
	runApplication<QrpayBackendApplication>(*args)
}
