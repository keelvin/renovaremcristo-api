package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgMemberTypeRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberTypeRestModel
import br.com.renovar.apirenovar.domain.pg.usecase.pgmembertype.FindAllPgMemberTypesUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/pg-member-type")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeControllerImpl @Autowired constructor(
    private val findAllPgMemberTypesUseCase: FindAllPgMemberTypesUseCase,
    private val pgMemberTypeRestConverter: PgMemberTypeRestConverter
): PgMemberTypeController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PgMemberTypeRestModel>>> {
        val objs = findAllPgMemberTypesUseCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { pgMemberTypeRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }
}