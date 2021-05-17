package br.com.renovar.apirenovar.security

import br.com.renovar.apirenovar.base.BaseInterceptor
import br.com.renovar.apirenovar.base.Middleware
import br.com.renovar.apirenovar.exceptions.NotAuthorizedException
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws

abstract class AbstractInterceptor<T: Middleware>(private val middleware: T) : BaseInterceptor<T>, HandlerInterceptor {

    @Throws(exceptionClasses = [NotAuthorizedException::class])
    override fun validate(request: HttpServletRequest) {
        val responseMiddleware = this.middleware.validate(request)

        if (!responseMiddleware.successful) {
            throw NotAuthorizedException(responseMiddleware.message)
        }
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        return try {
            this.validate(request)
            true
        } catch (e: NotAuthorizedException) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), e.message)
            false
        }
    }
}