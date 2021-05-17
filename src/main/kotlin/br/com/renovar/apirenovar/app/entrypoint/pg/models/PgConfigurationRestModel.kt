package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import java.time.DayOfWeek

class PgConfigurationRestModel(
    var id: Long = 0,
    var dayOfWeek: Int = DayOfWeek.MONDAY.value,
    var address: String = "",
    var imageId: String? = null
) : BaseRestModel