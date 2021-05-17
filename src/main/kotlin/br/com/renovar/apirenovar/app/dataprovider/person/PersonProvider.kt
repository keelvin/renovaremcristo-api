package br.com.renovar.apirenovar.app.dataprovider.person

import br.com.renovar.apirenovar.app.dataprovider.person.converters.PersonEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.repository.PersonRepository
import br.com.renovar.apirenovar.domain.person.dataprovider.PersonDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonProvider @Autowired constructor(
    private val personEntityConverter: PersonEntityConverter,
    private val personRepository: PersonRepository
) : PersonDataProvider {
    override fun findAllActives() = this.personRepository.findAllByActiveIsTrue().map {
        personEntityConverter.mapToEntity(it)
    }
}