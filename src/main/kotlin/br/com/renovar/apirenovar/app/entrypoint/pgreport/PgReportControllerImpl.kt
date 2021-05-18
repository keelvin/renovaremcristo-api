package br.com.renovar.apirenovar.app.entrypoint.pgreport

import br.com.renovar.apirenovar.app.entrypoint.pgreport.converters.PgReportRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pgreport.usecase.FindAllReportsByPgOrderByDateDescUseCase
import br.com.renovar.apirenovar.domain.pgreport.usecase.SaveReportUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/report")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportControllerImpl constructor(
    private val pgReportRestConverter: PgReportRestConverter,
    private val findAllReportsByPgOrderByDateDescUseCase: FindAllReportsByPgOrderByDateDescUseCase,
    private val saveReportUseCase: SaveReportUseCase
) : PgReportController {


    @GetMapping(value = ["/pg/{pgId}/orderByDate"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByPgId(@PathVariable("pgId") pgId: Long): ResponseEntity<ResponseData<List<PgReportRestModel>>> {
        return ResponseEntity(
            ResponseData.success(findAllReportsByPgOrderByDateDescUseCase.execute(pgId).map {
                pgReportRestConverter.mapToRestModel(it)
            }),
            HttpStatus.OK
        )
    }

    @PostMapping(
        value = ["/"],
        consumes = [AppCommons.APPLICATION_JSON_UTF8],
        produces = [AppCommons.APPLICATION_JSON_UTF8]
    )
    override fun create(@RequestBody obj: PgReportRestModel): ResponseEntity<ResponseData<PgReportRestModel>> {
        return try {
            val objSaved = saveReportUseCase.execute(pgReportRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(pgReportRestConverter.mapToRestModel(objSaved)),
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