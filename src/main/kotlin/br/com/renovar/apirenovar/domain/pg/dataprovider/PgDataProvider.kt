package br.com.renovar.apirenovar.domain.pg.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface PgDataProvider : DataProvider<Pg> {
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