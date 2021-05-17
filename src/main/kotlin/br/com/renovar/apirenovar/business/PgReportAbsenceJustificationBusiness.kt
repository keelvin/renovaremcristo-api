package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.PgReportAbsenceJustificationContract
import br.com.renovar.apirenovar.entities.PgReportAbsenceJustification
import br.com.renovar.apirenovar.repositories.PgReportAbsenceJustificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationBusiness(@Autowired private val repository: PgReportAbsenceJustificationRepository) :
        BaseBusiness<PgReportAbsenceJustification, Long, PgReportAbsenceJustificationRepository>(repository), PgReportAbsenceJustificationContract