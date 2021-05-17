package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.Pg
import org.springframework.stereotype.Repository

@Repository
interface PgRepository: BaseRepository<Pg, Long> {

    fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<Pg>
    fun findAllByChurchId(churchId: Long): List<Pg>
    fun findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId: Long, networkId: Long): List<Pg>
    fun findAllByChurchIdAndNetworkId(churchId: Long, networkId: Long): List<Pg>
    fun findAllByNetworkIdAndActiveIsTrue(networkId: Long): List<Pg>
    fun findAllByNetworkId(networkId: Long): List<Pg>
    fun findAllByPgTypeIdAndActiveIsTrue(pgTypeId: Long): List<Pg>
    fun findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(pgTypeId: Long, churchId: Long, networkId: Long): List<Pg>
    fun findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId: Long, churchId: Long, networkId: Long): List<Pg>
    fun findAllByPgTypeIdAndNetworkId(pgTypeId: Long, networkId: Long): List<Pg>
    fun findAllByPgTypeIdAndChurchId(pgTypeId: Long, churchId: Long): List<Pg>
    fun findAllByActiveIsTrue(): List<Pg>

}