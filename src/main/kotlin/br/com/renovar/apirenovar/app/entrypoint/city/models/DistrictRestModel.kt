package br.com.renovar.apirenovar.app.entrypoint.city.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class DistrictRestModel(
    var id: Long = 0,
    var name: String = "",
    var cityId: Long = 0
): BaseRestModel