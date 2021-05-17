package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByPgTypeIdAndNetworkIdUseCase {
    fun execute(pgTypeId: Long, networkId: Long): List<Pg>
}