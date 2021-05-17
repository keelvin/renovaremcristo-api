package br.com.renovar.apirenovar.domain.person.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity

class PersonType(
    var id: Long = 0,
    var description: String = ""
): BaseEntity