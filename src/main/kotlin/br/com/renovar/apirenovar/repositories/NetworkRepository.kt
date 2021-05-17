package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.Network
import org.springframework.stereotype.Repository

@Repository
interface NetworkRepository : BaseRepository<Network, Long> {

    fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long): List<Network>
    fun findAllByActiveIsTrue(): List<Network>
    fun findAllByLeaderId(leaderId: Long): List<Network>

}