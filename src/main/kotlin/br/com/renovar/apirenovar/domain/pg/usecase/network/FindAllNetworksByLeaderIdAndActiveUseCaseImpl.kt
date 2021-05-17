package br.com.renovar.apirenovar.domain.pg.usecase.network

import br.com.renovar.apirenovar.domain.pg.dataprovider.NetworkDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Network
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllNetworksByLeaderIdAndActiveUseCaseImpl @Autowired constructor(
    private val networkDataProvider: NetworkDataProvider
): FindAllNetworksByLeaderIdAndActiveUseCase {
    override fun execute(leaderId: Long) = networkDataProvider.findAllByLeaderIdAndActiveIsTrue(leaderId)
}