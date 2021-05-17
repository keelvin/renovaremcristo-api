package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.CityContract
import br.com.renovar.apirenovar.entities.City
import br.com.renovar.apirenovar.repositories.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityBusiness(@Autowired private val repository: CityRepository) : BaseBusiness<City, Long, CityRepository>(repository), CityContract {
    override fun findAllByNameIgnoreCaseContains(filter: String) = this.repository.findAllByNameIgnoreCaseContains(filter)
}