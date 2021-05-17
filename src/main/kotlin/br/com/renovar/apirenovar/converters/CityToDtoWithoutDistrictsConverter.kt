package br.com.renovar.apirenovar.converters

import br.com.renovar.apirenovar.base.EntityResponseConverter
import br.com.renovar.apirenovar.dtos.CityWithoutDistrictsResponseDto
import br.com.renovar.apirenovar.entities.City

class CityToDtoWithoutDistrictsConverter : EntityResponseConverter<City, CityWithoutDistrictsResponseDto> {
    override fun convert(source: City) = CityWithoutDistrictsResponseDto(
        id = source.id,
        name = source.name,
        state = source.state
    )
}