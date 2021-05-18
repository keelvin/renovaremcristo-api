package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllMembersByPgIdUseCaseImpl constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
): FindAllMembersByPgIdUseCase {
    override fun execute(pgId: Long) = pgMemberDataProvider.findAllMembersByPgId(pgId)
}