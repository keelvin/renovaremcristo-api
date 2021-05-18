package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberModel
import org.springframework.stereotype.Repository

@Repository
interface PgMemberRepository : BaseRepository<PgMemberModel, Long> {
    fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long): List<PgMemberModel>
    fun findAllByPersonId(personId: Long): List<PgMemberModel>
}
