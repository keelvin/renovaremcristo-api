package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByChurchIdAndNetworkIdUseCase {
    fun execute(churchId: Long, networkId: Long): List<Pg>
}