package br.com.renovar.apirenovar.domain.pg.usecase.network

import br.com.renovar.apirenovar.domain.pg.entity.Network

interface FindAllNetworksByLeaderIdAndActiveUseCase {
    fun execute(leaderId: Long): List<Network>
}