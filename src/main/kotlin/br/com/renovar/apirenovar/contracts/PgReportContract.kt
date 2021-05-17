package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.PgReport
import java.util.*

interface PgReportContract : BaseContract<PgReport, Long> {
    fun findAllByPgId(pgId: Long): List<PgReport>
    fun findAllByDateBetween(initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdOrderByDateDesc(pgId: Long): List<PgReport>
}