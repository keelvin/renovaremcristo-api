package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel
import org.springframework.http.ResponseEntity

interface PgMemberController: BaseRestController<PgMemberRestModel, Long> {
    fun findAllPgsByPersonId(personId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>>
    fun findAllMembersByPgId(pgId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>>
}