package br.com.renovar.apirenovar.app.dataprovider.person.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.church.converters.ChurchEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityDistrictEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonModel
import br.com.renovar.apirenovar.domain.person.entity.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonEntityConverter @Autowired constructor(
    private val cityEntityConverter: CityEntityConverter,
    private val churchEntityConverter: ChurchEntityConverter,
    private val personTypeEntityConverter: PersonTypeEntityConverter,
    private val cityDistrictEntityConverter: CityDistrictEntityConverter
) : EntityConverter<PersonModel, Person> {

    override fun mapToModel(obj: Person) = PersonModel(
        id = obj.id,
        name = obj.name,
        email = obj.email,
        birthday = obj.birthday,
        phone = obj.phone,
        city = cityEntityConverter.mapToModel(obj.city),
        address = obj.address,
        church = churchEntityConverter.mapToModel(obj.church),
        personType = personTypeEntityConverter.mapToModel(obj.personType),
        district = if (obj.district == null) null else cityDistrictEntityConverter.mapToModel(obj.district!!),
        active = obj.active
    )

    override fun mapToEntity(obj: PersonModel) = Person(
        id = obj.id,
        name = obj.name,
        email = obj.email,
        birthday = obj.birthday,
        phone = obj.phone,
        city = cityEntityConverter.mapToEntity(obj.city),
        address = obj.address,
        church = churchEntityConverter.mapToEntity(obj.church),
        personType = personTypeEntityConverter.mapToEntity(obj.personType),
        district = if(obj.district == null) null else cityDistrictEntityConverter.mapToEntity(obj.district!!),
        active = obj.active
    )
}