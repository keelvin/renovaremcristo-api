package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.PgMember

interface PgMemberContract : BaseContract<PgMember, Long> {
    fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long): List<PgMember>
    fun findAllByPersonId(personId: Long): List<PgMember>
}