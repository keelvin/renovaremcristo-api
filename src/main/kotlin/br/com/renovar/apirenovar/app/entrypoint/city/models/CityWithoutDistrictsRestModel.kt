package br.com.renovar.apirenovar.app.entrypoint.city.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class CityWithoutDistrictsRestModel(
    var id: Long = 0,
    var name: String = "",
    var state: StateRestModel
): BaseRestModel