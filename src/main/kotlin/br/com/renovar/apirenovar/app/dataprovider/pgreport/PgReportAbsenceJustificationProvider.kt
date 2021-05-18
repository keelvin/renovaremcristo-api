package br.com.renovar.apirenovar.app.dataprovider.pgreport

import br.com.renovar.apirenovar.app.dataprovider.pgreport.converters.PgReportAbsenceJustificationEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.repository.PgReportAbsenceJustificationRepository
import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportAbsenceJustificationDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationProvider constructor(
    private val pgReportAbsenceJustificationEntityConverter: PgReportAbsenceJustificationEntityConverter,
    private val pgReportAbsenceJustificationRepository: PgReportAbsenceJustificationRepository
) : PgReportAbsenceJustificationDataProvider {

    override fun findAll() = pgReportAbsenceJustificationRepository.findAll().map {
        pgReportAbsenceJustificationEntityConverter.mapToEntity(it)
    }
}