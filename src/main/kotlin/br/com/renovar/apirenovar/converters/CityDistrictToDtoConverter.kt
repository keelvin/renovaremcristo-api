package br.com.renovar.apirenovar.converters

import br.com.renovar.apirenovar.base.EntityResponseConverter
import br.com.renovar.apirenovar.dtos.DistrictWithoutCityResponseDto
import br.com.renovar.apirenovar.entities.CityDistrict

class CityDistrictToDtoConverter : EntityResponseConverter<CityDistrict, DistrictWithoutCityResponseDto> {
    override fun convert(source: CityDistrict) = DistrictWithoutCityResponseDto(
        id = source.id,
        name = source.name
    )
}