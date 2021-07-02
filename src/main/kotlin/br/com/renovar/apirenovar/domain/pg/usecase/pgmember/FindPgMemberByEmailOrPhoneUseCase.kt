package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface FindPgMemberByEmailOrPhoneUseCase {
    fun execute(email: String, phone: String): PgMember?
}