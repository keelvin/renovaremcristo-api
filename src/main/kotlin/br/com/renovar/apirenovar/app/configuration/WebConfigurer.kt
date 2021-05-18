package br.com.renovar.apirenovar.app.configuration

import br.com.renovar.apirenovar.app.security.CommonInterceptor
import br.com.renovar.apirenovar.app.security.SecurityInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfigurer(
    private val securityInterceptor: SecurityInterceptor,
    private val commonInterceptor: CommonInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(commonInterceptor)

        registry.addInterceptor(securityInterceptor)
            .addPathPatterns("/api/v2/**")
            .excludePathPatterns("/api/v2/security/authenticate")
    }

}