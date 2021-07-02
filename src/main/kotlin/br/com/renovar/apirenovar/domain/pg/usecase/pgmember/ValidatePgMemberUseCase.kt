package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.ValidatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import kotlin.jvm.Throws

interface ValidatePgMemberUseCase {
    @Throws(ValidatePgMemberException::class)
    fun execute(obj: PgMember)
}