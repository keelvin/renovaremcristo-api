package br.com.renovar.apirenovar.dtos

import br.com.renovar.apirenovar.entities.PersonType
import java.util.*

class PersonResponseDto(
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var birthday: Date = Date(),
    var phone: String = "",
    var address: String = "",
    var district: DistrictWithoutCityResponseDto,
    var city: CityWithoutDistrictsResponseDto,
    var church: ChurchResponseDto,
    var personType: PersonType,
    var active: Boolean = true
)


