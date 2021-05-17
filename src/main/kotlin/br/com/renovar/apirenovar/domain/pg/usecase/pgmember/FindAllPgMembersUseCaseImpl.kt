package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgMembersUseCaseImpl @Autowired constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
): FindAllPgMembersUseCase {

    override fun execute() = pgMemberDataProvider.findAll()

}