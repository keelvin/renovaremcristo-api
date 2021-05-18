package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface FindAllPgsByPersonIdUseCase {
    fun execute(personId: Long): List<PgMember>
}