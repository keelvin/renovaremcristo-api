package br.com.renovar.apirenovar.domain.pgreport.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity
import br.com.renovar.apirenovar.domain.pg.entity.PgMember

class PgReportData(
    var id: Long = 0,
    var reportId: Long = 0,
    var member: PgMember,
    var situation: PgReportMemberSituation,
    var absenceJustification: PgReportAbsenceJustification?,
    var justification: String? = ""
): BaseEntity