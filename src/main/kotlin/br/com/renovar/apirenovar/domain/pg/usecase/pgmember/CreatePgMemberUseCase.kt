package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.CreatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import kotlin.jvm.Throws

interface CreatePgMemberUseCase {
    @Throws(CreatePgMemberException::class)
    fun execute(obj: PgMember): PgMember
}