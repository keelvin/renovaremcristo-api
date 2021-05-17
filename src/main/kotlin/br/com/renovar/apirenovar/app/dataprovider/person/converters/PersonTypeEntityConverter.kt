package br.com.renovar.apirenovar.app.dataprovider.person.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonTypeModel
import br.com.renovar.apirenovar.domain.person.entity.PersonType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeEntityConverter : EntityConverter<PersonTypeModel, PersonType> {
    override fun mapToModel(obj: PersonType) = PersonTypeModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PersonTypeModel) = PersonType(
        id = obj.id,
        description = obj.description
    )
}