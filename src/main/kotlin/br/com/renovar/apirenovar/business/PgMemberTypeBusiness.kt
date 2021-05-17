package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.entities.PgMemberType
import br.com.renovar.apirenovar.repositories.PgMemberTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeBusiness (@Autowired private val repository: PgMemberTypeRepository) : BaseBusiness<PgMemberType, Long, PgMemberTypeRepository>(repository)