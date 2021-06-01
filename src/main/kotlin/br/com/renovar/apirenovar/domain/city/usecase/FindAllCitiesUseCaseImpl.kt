package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.dataprovider.CityDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllCitiesUseCaseImpl @Autowired constructor(
    private val cityDataProvider: CityDataProvider
) : FindAllCitiesUseCase {

    @Cacheable(cacheNames = ["City"], key = "#root.method.name")
    override fun execute() = cityDataProvider.findAll()
}