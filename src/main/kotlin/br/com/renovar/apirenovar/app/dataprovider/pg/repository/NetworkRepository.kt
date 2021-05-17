package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pg.model.NetworkModel
import org.springframework.stereotype.Repository

@Repository
interface NetworkRepository : BaseRepository<NetworkModel, Long> {

    fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long): List<NetworkModel>
    fun findAllByActiveIsTrue(): List<NetworkModel>
    fun findAllByLeaderId(leaderId: Long): List<NetworkModel>

}