package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport

interface FindAllReportsByPgOrderByDateDescUseCase {
    fun execute(pgId: Long): List<PgReport>
}