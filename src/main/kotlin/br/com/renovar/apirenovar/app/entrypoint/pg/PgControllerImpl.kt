package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgRestModel
import br.com.renovar.apirenovar.domain.pg.usecase.pg.FindAllPgsByChurchIdUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pg.FindAllPgsByNetworkIdUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pg.FindAllPgsUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pg.FindPgByIdUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/pg")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgControllerImpl constructor(
    private val pgRestConverter: PgRestConverter,
    private val findAllPgsUseCase: FindAllPgsUseCase,
    private val findAllPgsByChurchIdUseCase: FindAllPgsByChurchIdUseCase,
    private val findAllPgsByNetworkIdUseCase: FindAllPgsByNetworkIdUseCase,
    private val findPgByIdUseCase: FindPgByIdUseCase
) : PgController {

    @GetMapping(value = ["/church/{churchId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByChurchId(@PathVariable("churchId") churchId: Long): ResponseEntity<ResponseData<List<PgRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgsByChurchIdUseCase.execute(churchId).map { pgRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/network/{networkId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByNetworkId(@PathVariable("networkId") networkId: Long): ResponseEntity<ResponseData<List<PgRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgsByNetworkIdUseCase.execute(networkId).map { pgRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PgRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgsUseCase.execute().map { pgRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findById(@PathVariable("id") id: Long): ResponseEntity<ResponseData<PgRestModel>> {
        val obj = findPgByIdUseCase.execute(id) ?: return ResponseEntity(
            ResponseData.failure("Não localizado registro com o código informado"),
            HttpStatus.BAD_REQUEST
        )

        return ResponseEntity(ResponseData.success(pgRestConverter.mapToRestModel(obj)), HttpStatus.OK)
    }
}