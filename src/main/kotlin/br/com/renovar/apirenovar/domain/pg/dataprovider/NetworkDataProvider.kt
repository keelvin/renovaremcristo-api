package br.com.renovar.apirenovar.domain.pg.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Network

interface NetworkDataProvider: DataProvider<Network> {
    fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long): List<Network>
    fun findAllByActiveIsTrue(): List<Network>
    fun findAllByLeaderId(leaderId: Long): List<Network>
}