package br.com.renovar.apirenovar.app.entrypoint.church

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.entrypoint.church.models.ChurchRestModel

interface ChurchController : BaseRestController<ChurchRestModel, Long>