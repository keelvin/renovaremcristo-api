package br.com.renovar.apirenovar.app.entrypoint.city.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class StateRestModel(
    var id: Long = 0,
    var name: String = "",
    var uf: String = ""
): BaseRestModel