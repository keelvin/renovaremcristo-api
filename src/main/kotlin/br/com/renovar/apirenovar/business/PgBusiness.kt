package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.contracts.PgContract
import br.com.renovar.apirenovar.entities.Pg
import br.com.renovar.apirenovar.repositories.PgRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgBusiness(@Autowired private val repository: PgRepository) : BaseBusiness<Pg, Long, PgRepository>(repository), PgContract {
    override fun findAllByChurchIdAndActiveIsTrue(churchId: Long) = this.repository.findAllByChurchIdAndActiveIsTrue(churchId)

    override fun findAllByChurchId(churchId: Long) = this.repository.findAllByChurchId(churchId)

    override fun findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId: Long, networkId: Long) = this.repository
        .findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId, networkId)

    override fun findAllByChurchIdAndNetworkId(churchId: Long, networkId: Long) = this.repository.findAllByChurchIdAndNetworkId(
        churchId, networkId
    )

    override fun findAllByNetworkIdAndActiveIsTrue(networkId: Long) = this.repository.findAllByNetworkIdAndActiveIsTrue(
        networkId
    )

    override fun findAllByNetworkId(networkId: Long) = this.repository.findAllByNetworkId(networkId)

    override fun findAllByPgTypeIdAndActiveIsTrue(pgTypeId: Long) = this.repository.findAllByPgTypeIdAndActiveIsTrue(
        pgTypeId
    )

    override fun findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(
        pgTypeId: Long,
        churchId: Long,
        networkId: Long
    ) = this.repository.findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(
        pgTypeId, churchId, networkId
    )

    override fun findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId: Long, churchId: Long, networkId: Long) =
        this.repository.findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId, churchId, networkId)

    override fun findAllByPgTypeIdAndNetworkId(pgTypeId: Long, networkId: Long) = this.repository
        .findAllByPgTypeIdAndNetworkId(pgTypeId, networkId)

    override fun findAllByPgTypeIdAndChurchId(pgTypeId: Long, churchId: Long) = this.repository.findAllByPgTypeIdAndChurchId(
        pgTypeId, churchId
    )

    override fun findAllByActiveIsTrue() = this.repository.findAllByActiveIsTrue()
}