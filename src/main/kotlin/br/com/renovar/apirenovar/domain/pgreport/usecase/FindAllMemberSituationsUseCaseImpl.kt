package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportMemberSituationDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllMemberSituationsUseCaseImpl constructor(
    private val pgReportMemberSituationDataProvider: PgReportMemberSituationDataProvider
) : FindAllMemberSituationsUseCase{

    override fun execute() = pgReportMemberSituationDataProvider.findAll()

}