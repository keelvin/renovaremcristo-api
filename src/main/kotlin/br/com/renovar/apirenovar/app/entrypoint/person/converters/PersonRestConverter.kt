package br.com.renovar.apirenovar.app.entrypoint.person.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.church.converters.ChurchRestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.converters.CityWithoutDistrictsRestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.converters.DistrictRestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonRestModel
import br.com.renovar.apirenovar.domain.person.entity.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonRestConverter @Autowired constructor(
    private val personTypeRestConverter: PersonTypeRestConverter,
    private val cityWithoutDistrictsRestConverter: CityWithoutDistrictsRestConverter,
    private val churchRestConverter: ChurchRestConverter,
    private val districtRestConverter: DistrictRestConverter
) : RestConverter<PersonRestModel, Person> {

    override fun mapToRestModel(obj: Person) = PersonRestModel(
        id = obj.id,
        name = obj.name,
        email = obj.email,
        birthday = obj.birthday,
        phone = obj.phone,
        city = cityWithoutDistrictsRestConverter.mapToRestModel(obj.city),
        address = obj.address,
        church = churchRestConverter.mapToRestModel(obj.church),
        personType = personTypeRestConverter.mapToRestModel(obj.personType),
        district = if (obj.district == null) null else districtRestConverter.mapToRestModel(obj.district!!),
        active = obj.active
    )

    override fun mapToEntity(obj: PersonRestModel) = Person(
        id = obj.id,
        name = obj.name,
        email = obj.email,
        birthday = obj.birthday,
        phone = obj.phone,
        city = cityWithoutDistrictsRestConverter.mapToEntity(obj.city),
        address = obj.address,
        church = churchRestConverter.mapToEntity(obj.church),
        personType = personTypeRestConverter.mapToEntity(obj.personType),
        district = if (obj.district == null) null else districtRestConverter.mapToEntity(obj.district!!),
        active = obj.active
    )
}