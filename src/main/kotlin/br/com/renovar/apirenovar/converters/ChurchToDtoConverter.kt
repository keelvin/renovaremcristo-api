package br.com.renovar.apirenovar.converters

import br.com.renovar.apirenovar.base.EntityResponseConverter
import br.com.renovar.apirenovar.dtos.ChurchResponseDto
import br.com.renovar.apirenovar.entities.Church

class ChurchToDtoConverter : EntityResponseConverter<Church, ChurchResponseDto> {
    override fun convert(source: Church) = ChurchResponseDto(
        id = source.id,
        name = source.name,
        email = source.email,
        cnpj = source.cnpj,
        phone = source.phone,
        pastorName = source.pastorName,
        address = source.address,
        city = CityToDtoWithoutDistrictsConverter().convert(source.city)
    )
}