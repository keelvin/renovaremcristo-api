package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrueUseCase {
    fun execute(pgTypeId: Long, churchId: Long, networkId: Long): List<Pg>
}