package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgsByPgTypeIdAndChurchIdAndNetworkIdUseCaseImpl @Autowired constructor(
    private val pgDataProvider: PgDataProvider
): FindAllPgsByPgTypeIdAndChurchIdAndNetworkIdUseCase {
    override fun execute(pgTypeId: Long, churchId: Long, networkId: Long) = pgDataProvider.findAllByPgTypeIdAndChurchIdAndNetworkId(
        pgTypeId, churchId, networkId
    )
}