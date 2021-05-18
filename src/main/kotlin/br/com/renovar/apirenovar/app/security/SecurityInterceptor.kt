package br.com.renovar.apirenovar.app.security

import br.com.renovar.apirenovar.app.security.middleware.TokenMiddleware
import org.springframework.stereotype.Component

@Component
class SecurityInterceptor(middleware: TokenMiddleware) : AbstractInterceptor<TokenMiddleware>(middleware)