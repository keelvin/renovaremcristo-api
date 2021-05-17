package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.Network

interface NetworkBusinessContract: BaseContract<Network, Long> {
    fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long): List<Network>
    fun findAllByActiveIsTrue(): List<Network>
    fun findAllByLeaderId(leaderId: Long): List<Network>
}