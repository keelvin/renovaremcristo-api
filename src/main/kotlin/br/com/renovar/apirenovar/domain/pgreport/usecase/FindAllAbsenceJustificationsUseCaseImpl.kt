package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportAbsenceJustificationDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllAbsenceJustificationsUseCaseImpl constructor(
    private val pgReportAbsenceJustificationDataProvider: PgReportAbsenceJustificationDataProvider
): FindAllAbsenceJustificationsUseCase {

    override fun execute() = pgReportAbsenceJustificationDataProvider.findAll()

}