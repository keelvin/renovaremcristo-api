package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.dataprovider.CityDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllCitiesUseCaseImpl @Autowired constructor(
    private val cityDataProvider: CityDataProvider
) : FindAllCitiesUseCase {
    override fun execute() = cityDataProvider.findAll()
}