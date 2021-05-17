package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity
import br.com.renovar.apirenovar.domain.person.entity.Person

class Network(
    var id: Long = 0,
    var name: String = "",
    var leader: Person,
    var active: Boolean = true
): BaseEntity