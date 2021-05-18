package br.com.renovar.apirenovar.app.entrypoint.pgreport.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.converters.PgRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pgreport.models.PgReportRestModel
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportRestConverter constructor(
    private val pgReportDataRestConverter: PgReportDataRestConverter,
    private val pgRestConverter: PgRestConverter
) : RestConverter<PgReportRestModel, PgReport> {
    override fun mapToRestModel(obj: PgReport) = PgReportRestModel(
        id = obj.id,
        pg = pgRestConverter.mapToRestModel(obj.pg),
        date = obj.date,
        data = obj.data.map { pgReportDataRestConverter.mapToRestModel(it) }.toMutableList()
    )

    override fun mapToEntity(obj: PgReportRestModel) = PgReport(
        id = obj.id,
        pg = pgRestConverter.mapToEntity(obj.pg),
        date = obj.date,
        data = obj.data.map { pgReportDataRestConverter.mapToEntity(it) }.toMutableList()
    )
}