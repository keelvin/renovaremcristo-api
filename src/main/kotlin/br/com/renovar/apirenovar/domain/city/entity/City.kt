package br.com.renovar.apirenovar.domain.city.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class City(
    var id: Long = 0,
    var name: String = "",
    var state: State,
    var districts: Collection<District>
): BaseEntity