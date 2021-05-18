package br.com.renovar.apirenovar.app.entrypoint.pgreport.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportMemberSituationRestModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportMemberSituation
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationRestConverter : RestConverter<PgReportMemberSituationRestModel, PgReportMemberSituation> {
    override fun mapToRestModel(obj: PgReportMemberSituation) = PgReportMemberSituationRestModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgReportMemberSituationRestModel) = PgReportMemberSituation(
        id = obj.id,
        description = obj.description
    )
}