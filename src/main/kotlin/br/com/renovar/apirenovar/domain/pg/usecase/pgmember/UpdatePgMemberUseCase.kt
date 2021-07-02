package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.UpdatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import kotlin.jvm.Throws

interface UpdatePgMemberUseCase {
    @Throws(UpdatePgMemberException::class)
    fun execute(obj: PgMember): PgMember
}