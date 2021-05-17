package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.NetworkEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.NetworkRepository
import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.dataprovider.NetworkDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Network
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkProvider @Autowired constructor(
    private val networkRepository: NetworkRepository,
    private val networkEntityConverter: NetworkEntityConverter
) : NetworkDataProvider {

    override fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long) = networkRepository.findAllByLeaderIdAndActiveIsTrue(
        leaderId
    ).map { networkEntityConverter.mapToEntity(it) }

    override fun findAllByActiveIsTrue() = networkRepository.findAllByActiveIsTrue().map {
        networkEntityConverter.mapToEntity(it)
    }

    override fun findAllByLeaderId(leaderId: Long) = networkRepository.findAllByLeaderId(
        leaderId
    ).map { networkEntityConverter.mapToEntity(it) }

    override fun findAll() = networkRepository.findAll().map {
        networkEntityConverter.mapToEntity(it)
    }

    override fun findById(id: Long) = networkRepository.findById(id).orElse(null)?.let {
        return@let networkEntityConverter.mapToEntity(it)
    }

    @Throws(exceptionClasses = [SaveException::class])
    override fun save(obj: Network) = networkEntityConverter.mapToEntity(
        networkRepository.save(networkEntityConverter.mapToModel(obj))
    )
}