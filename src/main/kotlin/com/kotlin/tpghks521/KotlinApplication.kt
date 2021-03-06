package com.kotlin.tpghks521

import com.tpghks521.boot.java.pr.Application
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
open class KotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinApplication>(*args)
        }
    }
}