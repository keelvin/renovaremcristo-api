package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.business.PersonTypeBusiness
import br.com.renovar.apirenovar.entities.PersonType
import br.com.renovar.apirenovar.repositories.PersonTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person-type")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeRestController(@Autowired private val business: PersonTypeBusiness) : BaseRestController<PersonType, Long, PersonTypeRepository, PersonTypeBusiness>(business)