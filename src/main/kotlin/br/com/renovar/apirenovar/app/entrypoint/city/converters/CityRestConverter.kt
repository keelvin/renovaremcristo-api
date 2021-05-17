package br.com.renovar.apirenovar.app.entrypoint.city.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityRestModel
import br.com.renovar.apirenovar.domain.city.entity.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityRestConverter @Autowired constructor(
    private val stateRestConverter: StateRestConverter,
    private val districtRestConverter: DistrictRestConverter
) : RestConverter<CityRestModel, City> {
    override fun mapToRestModel(obj: City) = CityRestModel(
        id = obj.id,
        name = obj.name,
        state = stateRestConverter.mapToRestModel(obj.state),
        districts = obj.districts.map { districtRestConverter.mapToRestModel(it) }
    )

    override fun mapToEntity(obj: CityRestModel) = City(
        id = obj.id,
        name = obj.name,
        state = stateRestConverter.mapToEntity(obj.state),
        districts = obj.districts.map { districtRestConverter.mapToEntity(it) }
    )
}