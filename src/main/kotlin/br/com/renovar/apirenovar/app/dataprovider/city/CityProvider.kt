package br.com.renovar.apirenovar.app.dataprovider.city

import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.repository.CityRepository
import br.com.renovar.apirenovar.domain.city.dataprovider.CityDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityProvider @Autowired constructor(
    private val cityEntityConverter: CityEntityConverter,
    private val cityRepository: CityRepository
) : CityDataProvider {

    override fun findById(id: Long) = cityRepository.findById(id).orElse(null)?.let {
        return@let cityEntityConverter.mapToEntity(it)
    }

    override fun findAll() = cityRepository.findAllByOrderByNameAsc().map {
        cityEntityConverter.mapToEntity(it)
    }

    override fun filterByName(filter: String) = cityRepository.findAllByNameIgnoreCaseContainsOrderByNameAsc(filter)
        .map { cityEntityConverter.mapToEntity(it)}
}