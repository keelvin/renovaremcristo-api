package br.com.renovar.apirenovar.app.entrypoint.pg.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonRestModel
import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Temporal
import javax.persistence.TemporalType

class PgMemberRestModel(
    var id: Long = 0,
    var pg: PgRestModel? = null,
    var pgId: Long = 0,
    var person: PersonRestModel,
    var type: PgMemberTypeRestModel,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var registeredAt: Date = Date()
) : BaseRestModel