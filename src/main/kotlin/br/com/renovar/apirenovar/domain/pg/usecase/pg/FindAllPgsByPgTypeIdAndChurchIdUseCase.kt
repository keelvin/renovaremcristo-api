package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByPgTypeIdAndChurchIdUseCase {
    fun execute(pgTypeId: Long, churchId: Long): List<Pg>
}