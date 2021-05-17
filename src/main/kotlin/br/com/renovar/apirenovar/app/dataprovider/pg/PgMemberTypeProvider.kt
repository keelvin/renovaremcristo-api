package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgMemberTypeEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.PgMemberTypeRepository
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberTypeDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeProvider @Autowired constructor(
    private val pgMemberTypeRepository: PgMemberTypeRepository,
    private val pgMemberTypeEntityConverter: PgMemberTypeEntityConverter
): PgMemberTypeDataProvider {

    override fun findAll() = pgMemberTypeRepository.findAll().map {
        pgMemberTypeEntityConverter.mapToEntity(it)
    }

}