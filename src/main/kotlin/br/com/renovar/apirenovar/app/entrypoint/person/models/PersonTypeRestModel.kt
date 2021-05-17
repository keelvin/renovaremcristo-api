package br.com.renovar.apirenovar.app.entrypoint.person.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel

class PersonTypeRestModel(
    var id: Long = 0,
    var description: String = ""
): BaseRestModel