package br.com.renovar.apirenovar.domain.pg.usecase.pgauth

import br.com.renovar.apirenovar.base.toMd5
import br.com.renovar.apirenovar.domain.commons.JWTUtils
import br.com.renovar.apirenovar.domain.pg.entity.PgAuthResponse
import br.com.renovar.apirenovar.domain.pg.usecase.pgauth.exceptions.AuthFailedException
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthenticateUseCaseImpl constructor(
    private val findPgAuthByLoginAndPasswordUseCase: FindPgAuthByLoginAndPasswordUseCase
) : PgAuthenticateUseCase {

    @Throws(exceptionClasses = [AuthFailedException::class])
    override fun execute(login: String, password: String): PgAuthResponse {
        val pgAuth = findPgAuthByLoginAndPasswordUseCase.execute(
            login, password.toMd5()
        ) ?: throw AuthFailedException()

        return PgAuthResponse(
            token = JWTUtils.newToken(pgAuth.pgId),
            pgId = pgAuth.pgId
        )
    }

}