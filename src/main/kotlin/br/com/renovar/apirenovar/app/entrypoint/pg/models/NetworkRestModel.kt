package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonRestModel

class NetworkRestModel(
    var id: Long = 0,
    var name: String = "",
    var leader: PersonRestModel,
    var active: Boolean = true
): BaseRestModel