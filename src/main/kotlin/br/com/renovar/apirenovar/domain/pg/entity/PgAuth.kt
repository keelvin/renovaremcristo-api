package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class PgAuth(
    var login: String = "",
    var password: String = "",
    var pgId: Long = 0
) : BaseEntity