package br.com.renovar.apirenovar.domain.city.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class District(
    var id: Long = 0,
    var name: String = "",
    var cityId: Long = 0
): BaseEntity