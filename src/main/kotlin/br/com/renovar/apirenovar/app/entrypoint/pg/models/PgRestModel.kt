package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.church.models.ChurchRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityWithoutDistrictsRestModel

class PgRestModel(
    var id: Long = 0,
    var name: String = "",
    var network: NetworkRestModel,
    var church: ChurchRestModel,
    var city: CityWithoutDistrictsRestModel,
    var pgType: PgTypeRestModel,
    var configuration: PgConfigurationRestModel,
    var members: MutableList<PgMemberRestModel> = mutableListOf(),
    var active: Boolean = true
) : BaseRestModel