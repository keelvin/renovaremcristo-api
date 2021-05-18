package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class PgAuthResponse(
    var token: String = "",
    var pgId: Long = 0
) : BaseEntity