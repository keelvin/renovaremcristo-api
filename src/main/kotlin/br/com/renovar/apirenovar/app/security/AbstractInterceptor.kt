package br.com.renovar.apirenovar.app.security

import br.com.renovar.apirenovar.app.security.exceptions.NotAuthorizedException
import br.com.renovar.apirenovar.app.security.middleware.Middleware
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

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