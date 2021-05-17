package br.com.renovar.apirenovar.domain.church.entity

import br.com.renovar.apirenovar.domain.city.entity.City
import br.com.renovar.apirenovar.domain.commons.BaseEntity

class Church(
    var id: Long = 0,
    var name: String = "",
    var cnpj: String = "",
    var email: String = "",
    var phone: String = "",
    var pastorName: String = "",
    var address: String = "",
    var city: City
): BaseEntity