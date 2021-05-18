package br.com.renovar.apirenovar.app.entrypoint.pgreport.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel

class PgReportDataRestModel(
    var id: Long = 0,
    var reportId: Long? = 0,
    var member: PgMemberRestModel,
    var situation: PgReportMemberSituationRestModel,
    var absenceJustification: PgReportAbsenceJustificationRestModel?,
    var justification: String? = ""
): BaseRestModel