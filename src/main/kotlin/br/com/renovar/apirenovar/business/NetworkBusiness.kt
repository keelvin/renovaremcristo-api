package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.NetworkBusinessContract
import br.com.renovar.apirenovar.entities.Network
import br.com.renovar.apirenovar.repositories.NetworkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkBusiness(@Autowired private val repository: NetworkRepository) : BaseBusiness<Network, Long, NetworkRepository>(repository), NetworkBusinessContract {
    override fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long) =
        this.repository.findAllByLeaderIdAndActiveIsTrue(leaderId)

    override fun findAllByActiveIsTrue() = this.repository.findAllByActiveIsTrue()

    override fun findAllByLeaderId(leaderId: Long) = this.repository.findAllByLeaderId(leaderId)
}