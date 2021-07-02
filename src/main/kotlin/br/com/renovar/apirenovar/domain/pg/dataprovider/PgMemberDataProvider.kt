package br.com.renovar.apirenovar.domain.pg.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember

interface PgMemberDataProvider : DataProvider<PgMember> {
    fun findAllPgsByPersonId(personId: Long): List<PgMember>
    fun findAllMembersByPgId(pgId: Long): List<PgMember>
    fun findMemberByEmailOrPhone(email: String, phone: String): PgMember?
    fun findMemberByPhone(phone: String): PgMember?
    fun findMemberByEmail(email: String): PgMember?
}