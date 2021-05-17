package br.com.renovar.apirenovar.middlewares

import br.com.renovar.apirenovar.base.Middleware
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.utils.JWTUtils
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class TokenMiddleware : Middleware {
    override fun validate(request: HttpServletRequest): ResponseData<Boolean> {
        val tokenHeaderValue = request.getHeader("authorization")

        return if (tokenHeaderValue == null || !JWTUtils.isValidToken(tokenHeaderValue)) {
            ResponseData.failure("Usuário não autorizado a utilizar a API")
        } else {
            ResponseData.success(true)
        }
    }
}