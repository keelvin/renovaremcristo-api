package br.com.renovar.apirenovar.domain.security.usecase

import br.com.renovar.apirenovar.domain.commons.Parameters
import br.com.renovar.apirenovar.domain.security.dataprovider.SecurityDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ValidateTokenUseCaseImpl(
    private val securityDataProvider: SecurityDataProvider
): ValidateTokenUseCase {
    override fun execute(token: String) = securityDataProvider.isValidToken(token, Parameters.PRIVATE_KEY)
}