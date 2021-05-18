package br.com.renovar.apirenovar.domain.pg.usecase.pgauth

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgAuthDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindPgAuthByLoginAndPasswordUseCaseImpl @Autowired constructor(
    private val pgAuthDataProvider: PgAuthDataProvider
) : FindPgAuthByLoginAndPasswordUseCase {
    override fun execute(login: String, password: String) = pgAuthDataProvider.findByLoginAndPassword(login, password)
}