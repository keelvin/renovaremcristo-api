package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgsByPersonIdUseCaseImpl constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
): FindAllPgsByPersonIdUseCase {
    override fun execute(personId: Long) = pgMemberDataProvider.findAllPgsByPersonId(personId)
}