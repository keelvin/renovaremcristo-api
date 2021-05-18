package br.com.renovar.apirenovar.app.entrypoint.pgreport.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgRestModel
import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Temporal
import javax.persistence.TemporalType

class PgReportRestModel(
    var id: Long = 0,
    var pg: PgRestModel,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var date: Date = Date(),
    var data: MutableList<PgReportDataRestModel> = mutableListOf()
): BaseRestModel