package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import kotlin.jvm.Throws

interface SavePgMemberUseCase {
    @Throws(exceptionClasses = [SaveException::class])
    fun execute(obj: PgMember): PgMember
}