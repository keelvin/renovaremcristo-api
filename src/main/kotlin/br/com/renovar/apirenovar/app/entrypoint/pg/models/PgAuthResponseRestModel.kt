package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PgAuthResponseRestModel(
    var token: String = "",
    var pgId: Long
) : BaseRestModel