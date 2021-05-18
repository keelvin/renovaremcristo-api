package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgAuthEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.PgAuthRepository
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgAuthDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthProvider constructor(
    private val pgAuthRepository: PgAuthRepository,
    private val pgAuthEntityConverter: PgAuthEntityConverter
) : PgAuthDataProvider {
    override fun findByLoginAndPassword(login: String, password: String) = pgAuthRepository.findByLoginAndPassword(
        login, password
    )?.let { return@let pgAuthEntityConverter.mapToEntity(it) }
}