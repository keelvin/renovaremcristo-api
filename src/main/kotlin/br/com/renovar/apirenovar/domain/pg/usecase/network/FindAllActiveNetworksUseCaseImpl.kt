package br.com.renovar.apirenovar.domain.pg.usecase.network

import br.com.renovar.apirenovar.domain.pg.dataprovider.NetworkDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllActiveNetworksUseCaseImpl @Autowired constructor(
    private val networkDataProvider: NetworkDataProvider
): FindAllActiveNetworksUseCase {
    override fun execute() = networkDataProvider.findAllByActiveIsTrue()
}