package br.com.renovar.apirenovar.dtos

import br.com.renovar.apirenovar.entities.State

class CityWithoutDistrictsResponseDto(
    var id: Long = 0,
    var name: String = "",
    var state: State
)