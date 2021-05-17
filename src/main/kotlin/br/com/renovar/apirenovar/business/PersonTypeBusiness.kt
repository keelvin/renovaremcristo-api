package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.entities.PersonType
import br.com.renovar.apirenovar.repositories.PersonTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeBusiness(@Autowired private val repository: PersonTypeRepository) : BaseBusiness<PersonType, Long, PersonTypeRepository>(repository)