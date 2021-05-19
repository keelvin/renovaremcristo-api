package br.com.renovar.apirenovar.app.dataprovider.pgreport

import br.com.renovar.apirenovar.app.dataprovider.pgreport.converters.PgReportEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pgreport.repository.PgReportRepository
import br.com.renovar.apirenovar.domain.pgreport.dataprovider.PgReportDataProvider
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportProvider constructor(
    private val pgReportEntityConverter: PgReportEntityConverter,
    private val pgReportRepository: PgReportRepository
) : PgReportDataProvider {

    override fun findAllByPgId(pgId: Long) = pgReportRepository.findAllByPgId(pgId).map {
        pgReportEntityConverter.mapToEntity(it)
    }

    override fun findAllByDateBetween(initialDate: Date, finalDate: Date) = pgReportRepository.findAllByDateBetween(
        initialDate, finalDate
    ).map { pgReportEntityConverter.mapToEntity(it) }

    override fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date) = pgReportRepository.findAllByPgIdAndDateBetween(
        pgId, initialDate, finalDate
    ).map { pgReportEntityConverter.mapToEntity(it) }

    override fun findAllByPgIdOrderByDateDesc(pgId: Long) = pgReportRepository.findAllByPgIdOrderByDateDesc(pgId).map {
        pgReportEntityConverter.mapToEntity(it)
    }

    override fun findByPgIdAndDate(pgId: Long, date: Date) = pgReportRepository.findByPgIdAndDate(
        pgId, date
    )?.let { return@let pgReportEntityConverter.mapToEntity(it) }

    override fun save(obj: PgReport) = pgReportEntityConverter.mapToEntity(
        pgReportRepository.save(pgReportEntityConverter.mapToModel(obj))
    )

}