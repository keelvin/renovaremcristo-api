package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.business.PgReportMemberSituationBusiness
import br.com.renovar.apirenovar.entities.PgReportMemberSituation
import br.com.renovar.apirenovar.repositories.PgReportMemberSituationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/report/member-situation")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationRestController(@Autowired private val business: PgReportMemberSituationBusiness) :
        BaseRestController<PgReportMemberSituation, Long, PgReportMemberSituationRepository, PgReportMemberSituationBusiness>(business)