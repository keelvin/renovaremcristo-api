package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.converters.PersonEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.NetworkModel
import br.com.renovar.apirenovar.domain.pg.entity.Network
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkEntityConverter @Autowired constructor(
    private val personEntityConverter: PersonEntityConverter
) : EntityConverter<NetworkModel, Network> {
    override fun mapToModel(obj: Network) = NetworkModel(
        id = obj.id,
        name = obj.name,
        leader = personEntityConverter.mapToModel(obj.leader),
        active = obj.active
    )

    override fun mapToEntity(obj: NetworkModel) = Network(
        id = obj.id,
        name = obj.name,
        leader = personEntityConverter.mapToEntity(obj.leader),
        active = obj.active
    )
}