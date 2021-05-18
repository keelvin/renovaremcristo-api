package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberTypeRestModel

interface PgMemberTypeController: BaseRestController<PgMemberTypeRestModel, Long>