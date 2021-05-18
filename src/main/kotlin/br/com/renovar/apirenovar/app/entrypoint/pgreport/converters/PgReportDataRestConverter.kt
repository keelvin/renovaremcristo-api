package br.com.renovar.apirenovar.app.entrypoint.pgreport.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgMemberRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportDataRestModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportData
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportDataRestConverter constructor(
    private val pgMemberRestConverter: PgMemberRestConverter,
    private val pgReportMemberSituationRestConverter: PgReportMemberSituationRestConverter,
    private val pgReportAbsenceJustificationRestConverter: PgReportAbsenceJustificationRestConverter
): RestConverter<PgReportDataRestModel, PgReportData> {
    override fun mapToRestModel(obj: PgReportData) = PgReportDataRestModel(
        id = obj.id,
        reportId = obj.reportId,
        member = pgMemberRestConverter.mapToRestModel(obj.member),
        situation = pgReportMemberSituationRestConverter.mapToRestModel(obj.situation),
        absenceJustification = if (obj.absenceJustification == null) null else pgReportAbsenceJustificationRestConverter.mapToRestModel(
            obj.absenceJustification!!
        ),
        justification = obj.justification
    )

    override fun mapToEntity(obj: PgReportDataRestModel) = PgReportData(
        id = obj.id,
        reportId = obj.reportId ?: 0,
        member = pgMemberRestConverter.mapToEntity(obj.member),
        situation = pgReportMemberSituationRestConverter.mapToEntity(obj.situation),
        absenceJustification = if (obj.absenceJustification == null) null else pgReportAbsenceJustificationRestConverter.mapToEntity(
            obj.absenceJustification!!
        ),
        justification = obj.justification
    )
}