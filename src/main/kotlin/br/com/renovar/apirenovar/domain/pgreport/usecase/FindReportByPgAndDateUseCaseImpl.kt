package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindReportByPgAndDateUseCaseImpl(
    private val pgReportDataProvider: PgReportDataProvider
) : FindReportByPgAndDateUseCase {
    override fun execute(pgId: Long, date: Date) = pgReportDataProvider.findByPgIdAndDate(pgId, date)
}