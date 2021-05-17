package br.com.renovar.apirenovar

import br.com.renovar.apirenovar.security.CommonInterceptor
import br.com.renovar.apirenovar.security.SecurityInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfigurer : WebMvcConfigurer {

    @Autowired
    private lateinit var securityInterceptor: SecurityInterceptor

    @Autowired
    private lateinit var commonInterceptor: CommonInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(commonInterceptor)

        registry.addInterceptor(securityInterceptor)
            .addPathPatterns("/api/**")
            .excludePathPatterns("/api/security/authenticate")
    }

}