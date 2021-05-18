package br.com.renovar.apirenovar.app.entrypoint.person

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonTypeRestModel

interface PersonTypeController : BaseRestController<PersonTypeRestModel, Long>