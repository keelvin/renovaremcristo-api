package br.com.renovar.apirenovar.security

import br.com.renovar.apirenovar.middlewares.AppHeaderMiddleware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CommonInterceptor(@Autowired private val middleware: AppHeaderMiddleware) : AbstractInterceptor<AppHeaderMiddleware>(middleware)