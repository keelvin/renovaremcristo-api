package br.com.renovar.apirenovar.domain.pgreport.entity

import br.com.renovar.apirenovar.domain.commons.BaseEntity
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import java.util.*

class PgReport(
    var id: Long = 0,
    var pg: Pg,
    var date: Date = Date(),
    val data: MutableList<PgReportData> = mutableListOf(),
): BaseEntity