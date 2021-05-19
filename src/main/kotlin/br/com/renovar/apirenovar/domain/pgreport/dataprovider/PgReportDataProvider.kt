package br.com.renovar.apirenovar.domain.pgreport.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import java.util.*

interface PgReportDataProvider : DataProvider<PgReport> {
    fun findAllByPgId(pgId: Long): List<PgReport>
    fun findAllByDateBetween(initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdOrderByDateDesc(pgId: Long): List<PgReport>
    fun findByPgIdAndDate(pgId: Long, date: Date): PgReport?
}