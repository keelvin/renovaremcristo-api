package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportDataProvider
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SaveReportUseCaseImpl constructor(
    private val pgReportDataProvider: PgReportDataProvider
) : SaveReportUseCase {

    @Throws(exceptionClasses = [SaveException::class])
    override fun execute(obj: PgReport): PgReport {
        repeat(obj.data.size) {
            obj.data[it].reportId = obj.id
        }

        try {
            return pgReportDataProvider.save(obj)
        } catch (e: Exception) {
            throw SaveException(e.message, e)
        }

    }
}