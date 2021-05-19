package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import java.util.*

interface FindReportByPgAndDateUseCase {
    fun execute(pgId: Long, date: Date): PgReport?
}