package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.dataprovider.DistrictDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllDistrictsByCityIdUseCaseImpl constructor(
    private val districtDataProvider: DistrictDataProvider
): FindAllDistrictsByCityIdUseCase {
    override fun execute(cityId: Long) = districtDataProvider.findAllByCityId(cityId)
}