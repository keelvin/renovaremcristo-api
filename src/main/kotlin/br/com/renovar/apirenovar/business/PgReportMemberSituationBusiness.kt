package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.PgReportMemberSituationContract
import br.com.renovar.apirenovar.entities.PgReportMemberSituation
import br.com.renovar.apirenovar.repositories.PgReportMemberSituationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationBusiness(@Autowired private val repository: PgReportMemberSituationRepository) :
    BaseBusiness<PgReportMemberSituation, Long, PgReportMemberSituationRepository>(repository),
    PgReportMemberSituationContract