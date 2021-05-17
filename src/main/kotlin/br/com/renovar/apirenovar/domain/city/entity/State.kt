package br.com.renovar.apirenovar.domain.city.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class State(
    var id: Long = 0,
    var name: String = "",
    var uf: String = ""
): BaseEntity