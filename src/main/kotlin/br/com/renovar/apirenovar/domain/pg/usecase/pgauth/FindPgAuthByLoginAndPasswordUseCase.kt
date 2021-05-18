package br.com.renovar.apirenovar.domain.pg.usecase.pgauth

import br.com.renovar.apirenovar.domain.pg.entity.PgAuth

interface FindPgAuthByLoginAndPasswordUseCase {
    fun execute(login: String, password: String): PgAuth?
}