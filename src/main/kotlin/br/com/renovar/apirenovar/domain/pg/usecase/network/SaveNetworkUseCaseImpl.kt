package br.com.renovar.apirenovar.domain.pg.usecase.network

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.dataprovider.NetworkDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Network
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SaveNetworkUseCaseImpl @Autowired constructor(
    private val networkDataProvider: NetworkDataProvider
): SaveNetworkUseCase {

    @Throws(exceptionClasses = [SaveException::class])
    override fun execute(network: Network): Network {
        try {
            return networkDataProvider.save(network)
        } catch (e: Exception) {
            throw SaveException(e.message, e)
        }
    }
}