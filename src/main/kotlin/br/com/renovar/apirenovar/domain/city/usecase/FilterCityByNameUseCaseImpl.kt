package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.dataprovider.CityDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FilterCityByNameUseCaseImpl constructor(
    private val cityDataProvider: CityDataProvider
) : FilterCityByNameUseCase {

    override fun execute(filter: String) = this.cityDataProvider.filterByName(filter)

}