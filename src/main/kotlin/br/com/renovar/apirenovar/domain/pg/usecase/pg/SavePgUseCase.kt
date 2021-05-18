package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface SavePgUseCase {
    @Throws(exceptionClasses = [SaveException::class])
    fun execute(pg: Pg): Pg
}