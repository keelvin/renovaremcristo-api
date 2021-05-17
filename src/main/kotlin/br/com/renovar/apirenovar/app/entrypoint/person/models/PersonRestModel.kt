package br.com.renovar.apirenovar.app.entrypoint.person.models

import br.com.renovar.apirenovar.app.commons.BaseRestModel
import br.com.renovar.apirenovar.app.entrypoint.church.models.ChurchRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityWithoutDistrictsRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.models.DistrictRestModel
import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Temporal
import javax.persistence.TemporalType

class PersonRestModel(
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var birthday: Date = Date(),
    var phone: String = "",
    var city: CityWithoutDistrictsRestModel,
    var address: String = "",
    var church: ChurchRestModel,
    var personType: PersonTypeRestModel,
    var district: DistrictRestModel?,
    var active: Boolean = true
): BaseRestModel