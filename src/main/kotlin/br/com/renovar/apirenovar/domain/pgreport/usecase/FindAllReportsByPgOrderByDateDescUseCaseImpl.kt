package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllReportsByPgOrderByDateDescUseCaseImpl constructor(
    private val pgReportDataProvider: PgReportDataProvider
): FindAllReportsByPgOrderByDateDescUseCase {
    override fun execute(pgId: Long) = pgReportDataProvider.findAllByPgIdOrderByDateDesc(pgId)
}