package br.com.renovar.apirenovar.app.entrypoint.pgreport

import br.com.renovar.apirenovar.app.entrypoint.pgreport.converters.PgReportMemberSituationRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportMemberSituationRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.pgreport.usecase.FindAllMemberSituationsUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/report/member-situation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationControllerImpl constructor(
    private val pgReportMemberSituationRestConverter: PgReportMemberSituationRestConverter,
    private val findAllMemberSituationsUseCase: FindAllMemberSituationsUseCase
): PgReportMemberSituationController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PgReportMemberSituationRestModel>>> {
        return ResponseEntity(
            ResponseData.success(
                findAllMemberSituationsUseCase.execute().map { pgReportMemberSituationRestConverter.mapToRestModel(it) }
            ),
            HttpStatus.OK
        )
    }
}