package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgMemberRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel
import br.com.renovar.apirenovar.domain.exceptions.CreatePgMemberException
import br.com.renovar.apirenovar.domain.exceptions.UpdatePgMemberException
import br.com.renovar.apirenovar.domain.pg.usecase.pgmember.CreatePgMemberUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pgmember.FindAllMembersByPgIdUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pgmember.FindAllPgsByPersonIdUseCase
import br.com.renovar.apirenovar.domain.pg.usecase.pgmember.UpdatePgMemberUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/pg-member")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberControllerImpl constructor(
    private val pgMemberRestConverter: PgMemberRestConverter,
    private val findAllPgsByPersonIdUseCase: FindAllPgsByPersonIdUseCase,
    private val findAllMembersByPgIdUseCase: FindAllMembersByPgIdUseCase,
    private val createPgMemberUseCase: CreatePgMemberUseCase,
    private val updatePgMemberUseCase: UpdatePgMemberUseCase
): PgMemberController {

    @GetMapping(value = ["/person/{personId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllPgsByPersonId(@PathVariable("personId") personId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllPgsByPersonIdUseCase.execute(personId).map { pgMemberRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/pg/{pgId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllMembersByPgId(@PathVariable("pgId") pgId: Long): ResponseEntity<ResponseData<List<PgMemberRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllMembersByPgIdUseCase.execute(pgId).map { pgMemberRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }

    @PostMapping(value = ["/"], consumes = [AppCommons.APPLICATION_JSON_UTF8], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun create(@RequestBody obj: PgMemberRestModel): ResponseEntity<ResponseData<PgMemberRestModel>> {
        return try {
            val objSaved = if (obj.id > 0) updatePgMemberUseCase.execute(pgMemberRestConverter.mapToEntity(obj))
                else createPgMemberUseCase.execute(pgMemberRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(pgMemberRestConverter.mapToRestModel(objSaved)),
                HttpStatus.OK
            )
        } catch (e: CreatePgMemberException) {
            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: UpdatePgMemberException) {
            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }

    }

}