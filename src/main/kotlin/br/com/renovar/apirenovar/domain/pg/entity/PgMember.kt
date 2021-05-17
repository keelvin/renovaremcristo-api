package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity
import br.com.renovar.apirenovar.domain.person.entity.Person
import java.util.*

class PgMember(
    var id: Long = 0,
    var pg: Pg? = null,
    var pgId: Long = 0,
    var person: Person,
    var type: PgMemberType,
    var registeredAt: Date = Date()
) : BaseEntity