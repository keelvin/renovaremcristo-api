package br.com.renovar.apirenovar.app.entrypoint.church.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityWithoutDistrictsRestModel

class ChurchRestModel(
    var id: Long = 0,
    var name: String = "",
    var cnpj: String = "",
    var email: String = "",
    var phone: String = "",
    var pastorName: String = "",
    var address: String = "",
    var city: CityWithoutDistrictsRestModel
): BaseRestModel