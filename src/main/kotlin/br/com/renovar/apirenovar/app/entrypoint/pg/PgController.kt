package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgRestModel
import org.springframework.http.ResponseEntity

interface PgController: BaseRestController<PgRestModel, Long> {
    fun findAllByChurchId(churchId: Long): ResponseEntity<ResponseData<List<PgRestModel>>>
    fun findAllByNetworkId(networkId: Long): ResponseEntity<ResponseData<List<PgRestModel>>>
}