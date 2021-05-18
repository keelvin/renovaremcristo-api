package br.com.renovar.apirenovar.app.entrypoint.pgreport.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportAbsenceJustificationRestModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportAbsenceJustification
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportAbsenceJustificationRestConverter : RestConverter<PgReportAbsenceJustificationRestModel, PgReportAbsenceJustification> {
    override fun mapToRestModel(obj: PgReportAbsenceJustification) = PgReportAbsenceJustificationRestModel(
        id = obj.id,
        description = obj.description,
        requireJustification = obj.requireJustification
    )

    override fun mapToEntity(obj: PgReportAbsenceJustificationRestModel) = PgReportAbsenceJustification(
        id = obj.id,
        description = obj.description,
        requireJustification = obj.requireJustification
    )
}