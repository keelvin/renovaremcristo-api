package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgAuthResponseRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgAuthResponseRestModel
import br.com.renovar.apirenovar.domain.pg.usecase.pgauth.PgAuthenticateUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pgauth.exceptions.AuthFailedException
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/security")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthControllerImpl constructor(
    private val pgAuthenticateUseCase: PgAuthenticateUseCase,
    private val pgAuthResponseRestConverter: PgAuthResponseRestConverter
) : PgAuthController {

    @GetMapping(value = ["/authenticate"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun authenticate(@RequestHeader("login") login: String,
                              @RequestHeader("password") password: String): ResponseEntity<ResponseData<PgAuthResponseRestModel>> {
        return try {
            ResponseEntity(
                ResponseData.success(pgAuthResponseRestConverter.mapToRestModel(
                    pgAuthenticateUseCase.execute(login, password)
                )),
                HttpStatus.OK
            )
        } catch (e: AuthFailedException) {
            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }
    }
}