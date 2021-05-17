package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel
import br.com.renovar.apirenovar.base.ResponseData
import org.springframework.http.ResponseEntity

interface PgMemberController: BaseRestController<PgMemberRestModel, Long> {
    fun findAllByPgId(pgId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>>
    fun findAllByPersonId(personId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>>
}