package br.com.renovar.apirenovar.domain.pg.usecase.pgauth

import br.com.renovar.apirenovar.domain.pg.entity.PgAuthResponse
import br.com.renovar.apirenovar.domain.pg.usecase.pgauth.exceptions.AuthFailedException

interface PgAuthenticateUseCase {
    @Throws(exceptionClasses = [AuthFailedException::class])
    fun execute(login: String, password: String): PgAuthResponse
}