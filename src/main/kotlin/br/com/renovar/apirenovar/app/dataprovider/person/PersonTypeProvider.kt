package br.com.renovar.apirenovar.app.dataprovider.person

import br.com.renovar.apirenovar.app.dataprovider.person.converters.PersonTypeEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.repository.PersonTypeRepository
import br.com.renovar.apirenovar.domain.person.dataprovider.PersonTypeDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeProvider @Autowired constructor(
    private val personTypeRepository: PersonTypeRepository,
    private val personTypeEntityConverter: PersonTypeEntityConverter
): PersonTypeDataProvider {

    override fun findAll() = personTypeRepository.findAll().map { personTypeEntityConverter.mapToEntity(it) }

}