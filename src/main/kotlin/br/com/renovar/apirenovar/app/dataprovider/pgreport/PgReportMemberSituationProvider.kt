package br.com.renovar.apirenovar.app.dataprovider.pgreport

import br.com.renovar.apirenovar.app.dataprovider.pgreport.converters.PgReportMemberSituationEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.repository.PgReportMemberSituationRepository
import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportMemberSituationDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationProvider constructor(
    private val pgReportMemberSituationEntityConverter: PgReportMemberSituationEntityConverter,
    private val pgReportMemberSituationRepository: PgReportMemberSituationRepository
) : PgReportMemberSituationDataProvider {

    override fun findAll() = pgReportMemberSituationRepository.findAll().map {
        pgReportMemberSituationEntityConverter.mapToEntity(it)
    }
}