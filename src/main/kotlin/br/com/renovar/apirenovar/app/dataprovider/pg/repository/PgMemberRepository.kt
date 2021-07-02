package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PgMemberRepository : BaseRepository<PgMemberModel, Long> {
    fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long): List<PgMemberModel>
    fun findAllByPersonId(personId: Long): List<PgMemberModel>

    @Query(value = "SELECT M.* FROM PG_MEMBER M JOIN PERSON P ON P.ID = M.PERSON_ID WHERE UPPER(P.EMAIL) = UPPER(:EMAIL) OR P.PHONE = :PHONE", nativeQuery = true)
    fun findMemberByEmailOrPhone(
        @Param("EMAIL") email: String,
        @Param("PHONE") phone: String
    ) : PgMemberModel?

    @Query(value = "SELECT M.* FROM PG_MEMBER M JOIN PERSON P ON P.ID = M.PERSON_ID WHERE UPPER(P.EMAIL) = UPPER(:EMAIL)", nativeQuery = true)
    fun findMemberByEmail(@Param("EMAIL") email: String): PgMemberModel?

    @Query(value = "SELECT M.* FROM PG_MEMBER M JOIN PERSON P ON P.ID = M.PERSON_ID WHERE UPPER(P.PHONE) = UPPER(:PHONE)", nativeQuery = true)
    fun findMemberByPhone(@Param("PHONE") phone: String): PgMemberModel?
}
