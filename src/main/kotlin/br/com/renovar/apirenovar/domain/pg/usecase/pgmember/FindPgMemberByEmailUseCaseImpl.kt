package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindPgMemberByEmailUseCaseImpl constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
) : FindPgMemberByEmailUseCase {

    override fun execute(email: String) = pgMemberDataProvider.findMemberByEmail(email)

}