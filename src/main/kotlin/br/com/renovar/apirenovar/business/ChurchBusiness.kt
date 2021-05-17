package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.entities.Church
import br.com.renovar.apirenovar.repositories.ChurchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchBusiness(@Autowired private val repository: ChurchRepository) : BaseBusiness<Church,  Long, ChurchRepository>(repository)