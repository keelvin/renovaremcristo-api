package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgModel
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PgRepository: BaseRepository<PgModel, Long> {

    fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<PgModel>
    fun findAllByChurchId(churchId: Long): List<PgModel>
    fun findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId: Long, networkId: Long): List<PgModel>
    fun findAllByChurchIdAndNetworkId(churchId: Long, networkId: Long): List<PgModel>
    fun findAllByNetworkIdAndActiveIsTrue(networkId: Long): List<PgModel>
    fun findAllByNetworkId(networkId: Long): List<PgModel>
    fun findAllByPgTypeIdAndActiveIsTrue(pgTypeId: Long): List<PgModel>
    fun findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(pgTypeId: Long, churchId: Long, networkId: Long): List<PgModel>
    fun findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId: Long, churchId: Long, networkId: Long): List<PgModel>
    fun findAllByPgTypeIdAndNetworkId(pgTypeId: Long, networkId: Long): List<PgModel>
    fun findAllByPgTypeIdAndChurchId(pgTypeId: Long, churchId: Long): List<PgModel>
    fun findAllByActiveIsTrue(): List<PgModel>


}