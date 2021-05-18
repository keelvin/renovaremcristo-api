package br.com.renovar.apirenovar.app.security

import br.com.renovar.apirenovar.app.security.middleware.AppHeaderMiddleware
import org.springframework.stereotype.Component

@Component
class CommonInterceptor(middleware: AppHeaderMiddleware) : AbstractInterceptor<AppHeaderMiddleware>(middleware)