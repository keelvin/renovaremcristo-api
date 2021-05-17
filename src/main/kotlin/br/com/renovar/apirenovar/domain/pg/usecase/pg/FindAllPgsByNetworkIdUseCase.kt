package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByNetworkIdUseCase {
    fun execute(networkId: Long): List<Pg>
}