package br.com.renovar.apirenovar.app.dataprovider.pgreport.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportMemberSituationModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportMemberSituation
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportMemberSituationEntityConverter : EntityConverter<PgReportMemberSituationModel, PgReportMemberSituation> {
    override fun mapToModel(obj: PgReportMemberSituation) = PgReportMemberSituationModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgReportMemberSituationModel) = PgReportMemberSituation(
        id = obj.id,
        description = obj.description
    )
}