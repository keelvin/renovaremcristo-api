package br.com.renovar.apirenovar.domain.pg.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface PgMemberDataProvider: DataProvider<PgMember> {
    fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long): List<PgMember>
    fun findAllByPersonId(personId: Long): List<PgMember>
}