package br.com.renovar.apirenovar.domain.person.usecase

import br.com.renovar.apirenovar.domain.person.dataprovider.PersonDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPersonUserCaseImpl @Autowired constructor(
    private val personDataProvider: PersonDataProvider
) : FindAllPersonUserCase {

    override fun execute() = personDataProvider.findAllActives()
}