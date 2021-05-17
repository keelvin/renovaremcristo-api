package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.business.PgReportAbsenceJustificationBusiness
import br.com.renovar.apirenovar.entities.PgReportAbsenceJustification
import br.com.renovar.apirenovar.repositories.PgReportAbsenceJustificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/report/absence-justification")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationRestController(@Autowired private val business: PgReportAbsenceJustificationBusiness) :
        BaseRestController<PgReportAbsenceJustification, Long, PgReportAbsenceJustificationRepository, PgReportAbsenceJustificationBusiness>(business)