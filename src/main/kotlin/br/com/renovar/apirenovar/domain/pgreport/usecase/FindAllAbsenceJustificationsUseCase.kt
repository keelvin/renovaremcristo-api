package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportAbsenceJustification

interface FindAllAbsenceJustificationsUseCase {
    fun execute(): List<PgReportAbsenceJustification>
}