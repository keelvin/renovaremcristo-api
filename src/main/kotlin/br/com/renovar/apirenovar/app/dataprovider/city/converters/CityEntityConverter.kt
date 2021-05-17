package br.com.renovar.apirenovar.app.dataprovider.city.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import br.com.renovar.apirenovar.domain.city.entity.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityEntityConverter @Autowired constructor(
    private val cityDistrictEntityConverter: CityDistrictEntityConverter,
    private val stateEntityConverter: StateEntityConverter
) : EntityConverter<CityModel, City> {

    override fun mapToModel(obj: City) = CityModel(
        id = obj.id,
        name = obj.name,
        districts = obj.districts.map {cityDistrictEntityConverter.mapToModel(it)}.toMutableList(),
        state = stateEntityConverter.mapToModel(obj.state)
    )

    override fun mapToEntity(obj: CityModel) = City(
        id = obj.id,
        name = obj.name,
        districts = obj.districts.map { cityDistrictEntityConverter.mapToEntity(it) },
        state = stateEntityConverter.mapToEntity(obj.state)
    )
}