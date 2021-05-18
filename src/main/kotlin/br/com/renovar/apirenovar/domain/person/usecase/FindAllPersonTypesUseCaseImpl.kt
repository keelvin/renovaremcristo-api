package br.com.renovar.apirenovar.domain.person.usecase

import br.com.renovar.apirenovar.domain.person.dataprovider.PersonTypeDataProvider
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPersonTypesUseCaseImpl constructor(
    private val personTypeDataProvider: PersonTypeDataProvider
) : FindAllPersonTypesUseCase {
    override fun execute() = personTypeDataProvider.findAll()
}