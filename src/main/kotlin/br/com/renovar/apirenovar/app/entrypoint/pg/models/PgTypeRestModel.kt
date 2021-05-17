package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PgTypeRestModel(
    var id: Long = 0,
    var description: String = ""
) : BaseRestModel