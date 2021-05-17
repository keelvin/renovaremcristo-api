package br.com.renovar.apirenovar.converters

import br.com.renovar.apirenovar.base.EntityResponseConverter
import br.com.renovar.apirenovar.dtos.PersonResponseDto
import br.com.renovar.apirenovar.entities.Person

class PersonToDtoConverter : EntityResponseConverter<Person, PersonResponseDto> {
    override fun convert(source: Person) = PersonResponseDto(
        id = source.id,
        name = source.name,
        email = source.email,
        birthday = source.birthday,
        phone = source.phone,
        address = source.address,
        district = CityDistrictToDtoConverter().convert(source.district),
        city = CityToDtoWithoutDistrictsConverter().convert(source.city),
        church = ChurchToDtoConverter().convert(source.church),
        personType = source.personType,
        active = source.active
    )
}