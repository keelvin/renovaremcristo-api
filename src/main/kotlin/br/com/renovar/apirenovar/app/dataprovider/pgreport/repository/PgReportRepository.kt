package br.com.renovar.apirenovar.app.dataprovider.pgreport.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportModel
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PgReportRepository : BaseRepository<PgReportModel, Long> {
    fun findAllByPgId(pgId: Long): List<PgReportModel>
    fun findAllByDateBetween(initialDate: Date, finalDate: Date): List<PgReportModel>
    fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date): List<PgReportModel>
    fun findAllByPgIdOrderByDateDesc(pgId: Long): List<PgReportModel>
    fun findByPgIdAndDate(pgId: Long, date: Date): PgReportModel?
}