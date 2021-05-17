package br.com.renovar.apirenovar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = ["br.com.renovar.apirenovar"])
class ApiRenovarApplication: SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ApiRenovarApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<ApiRenovarApplication>(*args)
}
