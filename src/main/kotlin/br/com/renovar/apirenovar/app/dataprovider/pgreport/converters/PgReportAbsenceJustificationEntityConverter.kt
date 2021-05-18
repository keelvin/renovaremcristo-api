package br.com.renovar.apirenovar.app.dataprovider.pgreport.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportAbsenceJustificationModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportAbsenceJustification
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationEntityConverter : EntityConverter<PgReportAbsenceJustificationModel, PgReportAbsenceJustification> {
    override fun mapToModel(obj: PgReportAbsenceJustification) = PgReportAbsenceJustificationModel(
        id = obj.id,
        description = obj.description,
        requireJustification = obj.requireJustification
    )

    override fun mapToEntity(obj: PgReportAbsenceJustificationModel) = PgReportAbsenceJustification(
        id = obj.id,
        description = obj.description,
        requireJustification = obj.requireJustification
    )
}