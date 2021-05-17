package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PgReport
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PgReportRepository : BaseRepository<PgReport, Long> {
    fun findAllByPgId(pgId: Long): List<PgReport>
    fun findAllByDateBetween(initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date): List<PgReport>
    fun findAllByPgIdOrderByDateDesc(pgId: Long): List<PgReport>
}