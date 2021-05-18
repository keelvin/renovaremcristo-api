package br.com.renovar.apirenovar.app.entrypoint.pgreport

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.pgreport.converters.PgReportAbsenceJustificationRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportAbsenceJustificationRestModel
import br.com.renovar.apirenovar.domain.pgreport.usecase.FindAllAbsenceJustificationsUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/report/absence-justification")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationControllerImpl constructor(
    private val pgReportAbsenceJustificationRestConverter: PgReportAbsenceJustificationRestConverter,
    private val findAllAbsenceJustificationsUseCase: FindAllAbsenceJustificationsUseCase
): PgReportAbsenceJustificationController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PgReportAbsenceJustificationRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllAbsenceJustificationsUseCase.execute().map {
                    pgReportAbsenceJustificationRestConverter.mapToRestModel(it)
                }
            ),
            HttpStatus.OK
        )
    }
}