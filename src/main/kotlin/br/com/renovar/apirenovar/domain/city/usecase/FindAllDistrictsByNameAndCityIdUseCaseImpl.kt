package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.dataprovider.DistrictDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllDistrictsByNameAndCityIdUseCaseImpl constructor(
    private val districtDataProvider: DistrictDataProvider
) : FindAllDistrictsByNameAndCityIdUseCase {
    override fun execute(name: String, cityId: Long) = districtDataProvider.filterByNameAndCityId(name, cityId)
}