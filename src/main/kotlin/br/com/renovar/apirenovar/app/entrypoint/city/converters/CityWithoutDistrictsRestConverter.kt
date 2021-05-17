package br.com.renovar.apirenovar.app.entrypoint.city.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityWithoutDistrictsRestModel
import br.com.renovar.apirenovar.domain.city.entity.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityWithoutDistrictsRestConverter @Autowired constructor(
    private val stateRestConverter: StateRestConverter,
) : RestConverter<CityWithoutDistrictsRestModel, City> {

    override fun mapToRestModel(obj: City) = CityWithoutDistrictsRestModel(
        id = obj.id,
        name = obj.name,
        state = stateRestConverter.mapToRestModel(obj.state)
    )

    override fun mapToEntity(obj: CityWithoutDistrictsRestModel) = City(
        id = obj.id,
        name = obj.name,
        state = stateRestConverter.mapToEntity(obj.state),
        districts = mutableListOf()
    )
}