package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.business.PgMemberTypeBusiness
import br.com.renovar.apirenovar.entities.PgMemberType
import br.com.renovar.apirenovar.repositories.PgMemberTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pg-member-type")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeRestController(@Autowired private val business: PgMemberTypeBusiness) : BaseRestController<PgMemberType, Long, PgMemberTypeRepository, PgMemberTypeBusiness>(business)