package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PgMember
import org.springframework.stereotype.Repository

@Repository
interface PgMemberRepository : BaseRepository<PgMember, Long> {
    fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long): List<PgMember>
    fun findAllByPersonId(personId: Long): List<PgMember>
}
