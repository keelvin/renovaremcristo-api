package br.com.renovar.apirenovar.app.entrypoint.city.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class CityRestModel(
    var id: Long = 0,
    var name: String = "",
    var districts: Collection<DistrictRestModel>,
    var state: StateRestModel
): BaseRestModel