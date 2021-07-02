package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface FindPgMemberByEmailUseCase {
    fun execute(email: String): PgMember?
}