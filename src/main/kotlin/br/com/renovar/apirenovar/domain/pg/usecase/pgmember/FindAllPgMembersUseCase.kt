package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface FindAllPgMembersUseCase {
    fun execute(): List<PgMember>
}