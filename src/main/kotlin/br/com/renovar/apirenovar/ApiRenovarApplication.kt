package br.com.renovar.apirenovar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication(scanBasePackages = ["br.com.renovar.apirenovar"])
@EnableCaching
class ApiRenovarApplication: SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ApiRenovarApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<ApiRenovarApplication>(*args)
}
