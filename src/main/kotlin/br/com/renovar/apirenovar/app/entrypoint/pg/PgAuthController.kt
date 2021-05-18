package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgAuthResponseRestModel
import org.springframework.http.ResponseEntity

interface PgAuthController {
    fun authenticate(login: String, password: String): ResponseEntity<ResponseData<PgAuthResponseRestModel>>
}