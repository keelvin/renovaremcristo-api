package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.church.entity.Church
import br.com.renovar.apirenovar.domain.city.entity.City
import br.com.renovar.apirenovar.domain.commons.BaseEntity

class Pg(
    var id: Long = 0,
    var name: String = "",
    var network: Network,
    var church: Church,
    var city: City,
    var pgType: PgType,
    var configuration: PgConfiguration,
    var members: MutableList<PgMember> = mutableListOf(),
    var active: Boolean = true
) : BaseEntity