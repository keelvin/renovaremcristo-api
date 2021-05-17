package br.com.renovar.apirenovar.base

import br.com.renovar.apirenovar.exceptions.NotAuthorizedException
import javax.servlet.http.HttpServletRequest
import kotlin.jvm.Throws

interface BaseInterceptor<T: Middleware> {

    @Throws(exceptionClasses = [NotAuthorizedException::class])
    fun validate(request: HttpServletRequest)
}