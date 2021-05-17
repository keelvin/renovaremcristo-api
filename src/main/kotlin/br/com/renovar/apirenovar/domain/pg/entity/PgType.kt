package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class PgType(
    var id: Long = 0,
    var description: String = ""
): BaseEntity