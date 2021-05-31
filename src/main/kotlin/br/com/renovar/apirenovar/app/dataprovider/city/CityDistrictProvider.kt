package br.com.renovar.apirenovar.app.dataprovider.city

import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityDistrictEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.repository.CityDistrictRepository
import br.com.renovar.apirenovar.domain.city.dataprovider.DistrictDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityDistrictProvider constructor(
    private val repository: CityDistrictRepository,
    private val converter: CityDistrictEntityConverter
) : DistrictDataProvider {
    override fun findAllByCityId(cityId: Long) = repository.findAllByCityIdOrderByNameAsc(cityId).map {
        converter.mapToEntity(it)
    }

    override fun filterByNameAndCityId(name: String, cityId: Long) = repository.findAllByNameAndCityIdOrderByNameAsc(
        name, cityId
    ).map { converter.mapToEntity(it) }
}