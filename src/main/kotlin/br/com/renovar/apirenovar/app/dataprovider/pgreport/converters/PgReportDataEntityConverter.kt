package br.com.renovar.apirenovar.app.dataprovider.pgreport.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgMemberEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportDataModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportData
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportDataEntityConverter constructor(
    private val pgMemberEntityConverter: PgMemberEntityConverter,
    private val pgReportMemberSituationEntityConverter: PgReportMemberSituationEntityConverter,
    private val pgReportAbsenceJustificationEntityConverter: PgReportAbsenceJustificationEntityConverter
) : EntityConverter<PgReportDataModel, PgReportData> {
    override fun mapToModel(obj: PgReportData) = PgReportDataModel(
        id = obj.id,
        //reportId = obj.reportId,
        member = pgMemberEntityConverter.mapToModel(obj.member),
        situation = pgReportMemberSituationEntityConverter.mapToModel(obj.situation),
        absenceJustification = if (obj.absenceJustification == null) null else pgReportAbsenceJustificationEntityConverter.mapToModel(obj.absenceJustification!!),
        justification = obj.justification
    )

    override fun mapToEntity(obj: PgReportDataModel) = PgReportData(
        id = obj.id,
        //reportId = obj.reportId,
        member = pgMemberEntityConverter.mapToEntity(obj.member),
        situation = pgReportMemberSituationEntityConverter.mapToEntity(obj.situation),
        absenceJustification = if (obj.absenceJustification == null) null else pgReportAbsenceJustificationEntityConverter.mapToEntity(obj.absenceJustification!!),
        justification = obj.justification
    )
}