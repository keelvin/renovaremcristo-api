package br.com.renovar.apirenovar.app.dataprovider.pgreport.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportEntityConverter constructor(
    private val pgReportDataEntityConverter: PgReportDataEntityConverter,
    private val pgEntityConverter: PgEntityConverter
) : EntityConverter<PgReportModel, PgReport> {
    override fun mapToModel(obj: PgReport) = PgReportModel(
        id = obj.id,
        pg = pgEntityConverter.mapToModel(obj.pg),
        date = obj.date,
        data = obj.data.map { pgReportDataEntityConverter.mapToModel(it) }.toMutableList()
    )

    override fun mapToEntity(obj: PgReportModel) = PgReport(
        id = obj.id,
        pg = pgEntityConverter.mapToEntity(obj.pg),
        date = obj.date,
        data = obj.data.map { pgReportDataEntityConverter.mapToEntity(it) }.toMutableList()
    )
}