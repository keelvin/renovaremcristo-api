package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.PgRepository
import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgProvider @Autowired constructor(
    private val pgRepository: PgRepository,
    private val pgEntityConverter: PgEntityConverter
) : PgDataProvider {

    override fun findAllByChurchIdAndActiveIsTrue(churchId: Long) = pgRepository.findAllByChurchIdAndActiveIsTrue(
        churchId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByChurchId(churchId: Long) = pgRepository.findAllByChurchId(churchId).map {
        pgEntityConverter.mapToEntity(it)
    }

    override fun findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId: Long, networkId: Long) = pgRepository.findAllByChurchIdAndNetworkIdAndActiveIsTrue(
        churchId, networkId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByChurchIdAndNetworkId(churchId: Long, networkId: Long) = pgRepository.findAllByChurchIdAndNetworkId(
        churchId, networkId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByNetworkIdAndActiveIsTrue(networkId: Long) = pgRepository.findAllByNetworkIdAndActiveIsTrue(
        networkId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByNetworkId(networkId: Long) = pgRepository.findAllByNetworkId(networkId).map {
        pgEntityConverter.mapToEntity(it)
    }

    override fun findAllByPgTypeIdAndActiveIsTrue(pgTypeId: Long) = pgRepository.findAllByPgTypeIdAndActiveIsTrue(
        pgTypeId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(
        pgTypeId: Long,
        churchId: Long,
        networkId: Long
    ) = pgRepository.findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(pgTypeId, churchId, networkId).map {
        pgEntityConverter.mapToEntity(it)
    }

    override fun findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId: Long, churchId: Long, networkId: Long) =
        pgRepository.findAllByPgTypeIdAndChurchIdAndNetworkId(pgTypeId, churchId, networkId).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByPgTypeIdAndNetworkId(pgTypeId: Long, networkId: Long) = pgRepository.findAllByPgTypeIdAndNetworkId(
        pgTypeId, networkId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByPgTypeIdAndChurchId(pgTypeId: Long, churchId: Long) = pgRepository.findAllByPgTypeIdAndChurchId(
        pgTypeId, churchId
    ).map { pgEntityConverter.mapToEntity(it) }

    override fun findAllByActiveIsTrue() = pgRepository.findAllByActiveIsTrue().map { pgEntityConverter.mapToEntity(it) }

    override fun findAll() = pgRepository.findAll().map { pgEntityConverter.mapToEntity(it) }

    override fun findById(id: Long) = pgRepository.findById(id).orElse(null)?.let { return@let pgEntityConverter.mapToEntity(it) }

    @Throws(exceptionClasses = [SaveException::class])
    override fun save(obj: Pg) = pgEntityConverter.mapToEntity(
        pgRepository.save(pgEntityConverter.mapToModel(obj))
    )
}