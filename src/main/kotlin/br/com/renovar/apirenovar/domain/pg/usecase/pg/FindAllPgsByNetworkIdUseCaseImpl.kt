package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgsByNetworkIdUseCaseImpl @Autowired constructor(
    private val pgDataProvider: PgDataProvider
) : FindAllPgsByNetworkIdUseCase {
    override fun execute(networkId: Long) = pgDataProvider.findAllByNetworkId(networkId)
}