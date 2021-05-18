package br.com.renovar.apirenovar.app.entrypoint.pgreport.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PgReportMemberSituationRestModel(
    var id: Long = 0,
    var description: String = ""
) : BaseRestModel