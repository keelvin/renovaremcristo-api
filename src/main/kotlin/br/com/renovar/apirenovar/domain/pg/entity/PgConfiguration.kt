package br.com.renovar.apirenovar.domain.pg.entity

import br.com.renovar.apirenovar.domain.city.entity.District
import br.com.renovar.apirenovar.domain.commons.BaseEntity
import java.time.DayOfWeek

class PgConfiguration(
    var id: Long = 0,
    var pg: Pg? = null,
    var address: String = "",
    var dayOfWeek: Int = DayOfWeek.MONDAY.value,
    var imageId: String? = null,
    var district: District
) : BaseEntity