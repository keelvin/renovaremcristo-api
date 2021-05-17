package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.base.toMd5
import br.com.renovar.apirenovar.configurations.StatusCode
import br.com.renovar.apirenovar.contracts.AuthContract
import br.com.renovar.apirenovar.dtos.AuthResponseDto
import br.com.renovar.apirenovar.utils.JWTUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class AuthBusiness : AuthContract {

    @Autowired
    private lateinit var pgAuthBusiness: PgAuthBusiness

    override fun authenticate(login: String, password: String): ResponseData<AuthResponseDto> {
        val authObject = pgAuthBusiness.findByLoginAndPassword(
            login,
            password.toMd5()
        ) ?: return ResponseData.failure(message = "Usuário ou senha inválidos", code = StatusCode.INVALID_LOGIN)

        return ResponseData.success(
            AuthResponseDto(
                token = JWTUtils.newToken(
                    authObject.pgId
                ),
                pgId = authObject.pgId
            )
        )
    }
}