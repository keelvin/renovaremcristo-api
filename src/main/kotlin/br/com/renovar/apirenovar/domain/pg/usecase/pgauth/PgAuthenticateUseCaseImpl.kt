package br.com.renovar.apirenovar.domain.pg.usecase.pgauth

import br.com.renovar.apirenovar.domain.commons.toMd5
import br.com.renovar.apirenovar.domain.pg.entity.PgAuthResponse
import br.com.renovar.apirenovar.domain.pg.usecase.pgauth.exceptions.AuthFailedException
import br.com.renovar.apirenovar.domain.security.usecase.GenerateTokenUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthenticateUseCaseImpl constructor(
    private val findPgAuthByLoginAndPasswordUseCase: FindPgAuthByLoginAndPasswordUseCase,
    private val generateTokenUseCase: GenerateTokenUseCase
) : PgAuthenticateUseCase {

    @Throws(exceptionClasses = [AuthFailedException::class])
    override fun execute(login: String, password: String): PgAuthResponse {
        val pgAuth = findPgAuthByLoginAndPasswordUseCase.execute(
            login, password.toMd5()
        ) ?: throw AuthFailedException()

        return PgAuthResponse(
            token = generateTokenUseCase.execute(pgAuth.pgId),
            pgId = pgAuth.pgId
        )
    }

}