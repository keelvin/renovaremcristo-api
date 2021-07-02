package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindPgMemberByEmailOrPhoneUseCaseImpl constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
): FindPgMemberByEmailOrPhoneUseCase {

    override fun execute(email: String, phone: String) = pgMemberDataProvider.findMemberByEmailOrPhone(email, phone)

}