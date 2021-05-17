package br.com.renovar.apirenovar.app.entrypoint.person.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonTypeRestModel
import br.com.renovar.apirenovar.domain.person.entity.PersonType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeRestConverter : RestConverter<PersonTypeRestModel, PersonType> {
    override fun mapToRestModel(obj: PersonType) = PersonTypeRestModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PersonTypeRestModel) = PersonType(
        id = obj.id,
        description = obj.description
    )
}