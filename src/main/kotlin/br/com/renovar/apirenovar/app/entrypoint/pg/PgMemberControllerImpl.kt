package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgMemberCompleteRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.usecase.pgmember.*
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/pg-member")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberControllerImpl constructor(
    private val pgMemberCompleteRestConverter: PgMemberCompleteRestConverter,
    private val savePgMemberUseCase: SavePgMemberUseCase,
    private val findAllPgMembersUseCase: FindAllPgMembersUseCase,
    private val findPgMemberByIdUseCase: FindPgMemberByIdUseCase,
    private val findAllPgMembersByPgIdOrderByPersonNameAscUseCase: FindAllPgMembersByPgIdOrderByPersonNameAscUseCase,
    private val findAllPgMembersByPersonIdUseCase: FindAllPgMembersByPersonIdUseCase
): PgMemberController {

    @GetMapping(value = ["/pg/{pgId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByPgId(@PathVariable("pgId") pgId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgMembersByPgIdOrderByPersonNameAscUseCase.execute(pgId).map {
                    pgMemberCompleteRestConverter.mapToRestModel(it)
                }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/person/{personId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByPersonId(@PathVariable("personId") personId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgMembersByPersonIdUseCase.execute(personId).map {
                    pgMemberCompleteRestConverter.mapToRestModel(it)
                }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PgMemberRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgMembersUseCase.execute().map {
                    pgMemberCompleteRestConverter.mapToRestModel(it)
                }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findById(@PathVariable("id") id: Long): ResponseEntity<ResponseData<PgMemberRestModel>> {
        val obj = findPgMemberByIdUseCase.execute(id) ?: return ResponseEntity(
            ResponseData.failure("Não encontrado registro com o código informado"),
            HttpStatus.BAD_REQUEST
        )

        return ResponseEntity(
            ResponseData.success(pgMemberCompleteRestConverter.mapToRestModel(obj)),
            HttpStatus.OK
        )
    }

    @PostMapping(
        value = ["/"],
        produces = [AppCommons.APPLICATION_JSON_UTF8],
        consumes = [AppCommons.APPLICATION_JSON_UTF8]
    )
    override fun create(obj: PgMemberRestModel): ResponseEntity<ResponseData<PgMemberRestModel>> {
        return try {
            val objSaved = savePgMemberUseCase.execute(pgMemberCompleteRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(pgMemberCompleteRestConverter.mapToRestModel(objSaved)),
                HttpStatus.OK
            )
        } catch (e: SaveException) {
            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }
    }

    @PutMapping(
        value = ["/"],
        produces = [AppCommons.APPLICATION_JSON_UTF8],
        consumes = [AppCommons.APPLICATION_JSON_UTF8]
    )
    override fun update(obj: PgMemberRestModel): ResponseEntity<ResponseData<PgMemberRestModel>> {
        return try {
            val objSaved = savePgMemberUseCase.execute(pgMemberCompleteRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(pgMemberCompleteRestConverter.mapToRestModel(objSaved)),
                HttpStatus.OK
            )
        } catch (e: SaveException) {
            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }
    }
}