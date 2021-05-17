package br.com.renovar.apirenovar.domain.pg.usecase.pgmembertype

import br.com.renovar.apirenovar.domain.pg.entity.PgMemberType

interface FindAllPgMemberTypesUseCase {
    fun execute(): List<PgMemberType>
}