package br.com.renovar.apirenovar.app.entrypoint.city.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.StateRestModel
import br.com.renovar.apirenovar.domain.city.entity.State
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class StateRestConverter : RestConverter<StateRestModel, State> {
    override fun mapToRestModel(obj: State) = StateRestModel(
        id = obj.id,
        name = obj.name,
        uf = obj.uf
    )

    override fun mapToEntity(obj: StateRestModel) = State(
        id = obj.id,
        name = obj.name,
        uf = obj.uf
    )
}