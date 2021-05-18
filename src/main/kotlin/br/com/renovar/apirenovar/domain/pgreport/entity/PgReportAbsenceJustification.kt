package br.com.renovar.apirenovar.domain.pgreport.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class PgReportAbsenceJustification(
    var id: Long = 0,
    var description: String = "",
    var requireJustification: Boolean = false
): BaseEntity