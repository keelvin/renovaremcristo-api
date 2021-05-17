package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByPgTypeIdAndActiveIsTrueUseCase {
    fun execute(pgTypeId: Long): List<Pg>
}