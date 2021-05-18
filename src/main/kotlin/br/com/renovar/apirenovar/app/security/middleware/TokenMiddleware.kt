package br.com.renovar.apirenovar.app.security.middleware

import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.domain.security.usecase.ValidateTokenUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class TokenMiddleware(
    private val validateTokenUseCase: ValidateTokenUseCase
) : Middleware {
    override fun validate(request: HttpServletRequest): ResponseData<Boolean> {
        val tokenHeaderValue = request.getHeader("authorization")

        return if (tokenHeaderValue == null || !validateTokenUseCase.execute(tokenHeaderValue)) {
            ResponseData.failure("Usuário não autorizado a utilizar a API")
        } else {
            ResponseData.success(true)
        }
    }
}