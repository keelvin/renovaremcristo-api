package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.converters.PersonRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.NetworkRestModel
import br.com.renovar.apirenovar.domain.pg.entity.Network
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkRestConverter @Autowired constructor(
    private val personRestConverter: PersonRestConverter
): RestConverter<NetworkRestModel, Network> {
    override fun mapToRestModel(obj: Network) = NetworkRestModel(
        id = obj.id,
        name = obj.name,
        leader = personRestConverter.mapToRestModel(obj.leader),
        active = obj.active
    )

    override fun mapToEntity(obj: NetworkRestModel) = Network(
        id = obj.id,
        name = obj.name,
        leader = personRestConverter.mapToEntity(obj.leader),
        active = obj.active
    )
}