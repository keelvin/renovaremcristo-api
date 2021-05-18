package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface FindAllMembersByPgIdUseCase {
    fun execute(pgId: Long): List<PgMember>
}