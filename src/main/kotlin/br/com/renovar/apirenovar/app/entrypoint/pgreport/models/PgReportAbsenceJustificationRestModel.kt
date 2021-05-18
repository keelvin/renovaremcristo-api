package br.com.renovar.apirenovar.app.entrypoint.pgreport.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PgReportAbsenceJustificationRestModel(
    var id: Long = 0,
    var description: String = "",
    var requireJustification: Boolean = false
): BaseRestModel