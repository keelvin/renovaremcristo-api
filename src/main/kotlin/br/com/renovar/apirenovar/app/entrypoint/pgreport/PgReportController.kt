package br.com.renovar.apirenovar.app.entrypoint.pgreport

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportRestModel
import org.springframework.http.ResponseEntity

interface PgReportController : BaseRestController<PgReportRestModel, Long> {
    fun findAllByPgId(pgId: Long): ResponseEntity<ResponseData<List<PgReportRestModel>>>
}