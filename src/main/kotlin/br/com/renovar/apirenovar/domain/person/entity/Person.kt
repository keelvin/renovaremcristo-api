package br.com.renovar.apirenovar.domain.person.entity

import br.com.renovar.apirenovar.domain.church.entity.Church
import br.com.renovar.apirenovar.domain.city.entity.City
import br.com.renovar.apirenovar.domain.city.entity.District
import br.com.renovar.apirenovar.domain.commons.BaseEntity
import java.util.*

class Person(
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var birthday: Date = Date(),
    var phone: String = "",
    var city: City,
    var address: String = "",
    var church: Church,
    var personType: PersonType,
    var district: District?,
    var active: Boolean = true
): BaseEntity