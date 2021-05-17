package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindPgByIdUseCase {
    fun execute(id: Long): Pg?
}