package br.com.renovar.apirenovar.app.security

import br.com.renovar.apirenovar.app.security.exceptions.NotAuthorizedException
import br.com.renovar.apirenovar.app.security.middleware.Middleware
import javax.servlet.http.HttpServletRequest

interface BaseInterceptor<T: Middleware> {

    @Throws(exceptionClasses = [NotAuthorizedException::class])
    fun validate(request: HttpServletRequest)
}