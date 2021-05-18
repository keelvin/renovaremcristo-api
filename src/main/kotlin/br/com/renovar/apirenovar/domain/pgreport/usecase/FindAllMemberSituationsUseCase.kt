package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.pgreport.entity.PgReportMemberSituation

interface FindAllMemberSituationsUseCase {
    fun execute(): List<PgReportMemberSituation>
}