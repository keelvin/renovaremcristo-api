package br.com.renovar.apirenovar.app.dataprovider.city.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.model.StateModel
import br.com.renovar.apirenovar.domain.city.entity.State
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class StateEntityConverter : EntityConverter<StateModel, State> {
    override fun mapToModel(obj: State) = StateModel(
        id = obj.id,
        name = obj.name,
        uf = obj.uf
    )

    override fun mapToEntity(obj: StateModel) = State(
        id = obj.id,
        name = obj.name,
        uf = obj.uf
    )
}