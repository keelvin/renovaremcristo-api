package br.com.renovar.apirenovar.security

import br.com.renovar.apirenovar.middlewares.TokenMiddleware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SecurityInterceptor(@Autowired private val middleware: TokenMiddleware) : AbstractInterceptor<TokenMiddleware>(middleware)