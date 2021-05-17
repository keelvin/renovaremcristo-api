package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.PgMemberContract
import br.com.renovar.apirenovar.entities.PgMember
import br.com.renovar.apirenovar.repositories.PgMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberBusiness(@Autowired private val repository: PgMemberRepository) : BaseBusiness<PgMember, Long, PgMemberRepository>(repository), PgMemberContract {
    override fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long) = this.repository.findAlLByPgIdOrderByPersonNameAsc(pgId)
    override fun findAllByPersonId(personId: Long) = this.repository.findAllByPersonId(personId)
}