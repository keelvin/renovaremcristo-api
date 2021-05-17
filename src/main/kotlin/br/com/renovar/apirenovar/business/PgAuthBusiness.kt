package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.PgAuthContract
import br.com.renovar.apirenovar.entities.PgAuth
import br.com.renovar.apirenovar.repositories.PgAuthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthBusiness(@Autowired private val repository: PgAuthRepository) : BaseBusiness<PgAuth, Long, PgAuthRepository>(repository), PgAuthContract {

    override fun findByLoginAndPassword(login: String, password: String) = this.repository.findByLoginAndPassword(
        login,
        password
    )

}