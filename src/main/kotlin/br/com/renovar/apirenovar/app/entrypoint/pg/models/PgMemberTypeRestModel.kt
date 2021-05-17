package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PgMemberTypeRestModel(
    var id: Long = 0,
    var description: String = ""
): BaseRestModel