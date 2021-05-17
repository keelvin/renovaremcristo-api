package br.com.renovar.apirenovar.app.entrypoint.city.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.DistrictRestModel
import br.com.renovar.apirenovar.domain.city.entity.District
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class DistrictRestConverter : RestConverter<DistrictRestModel, District> {
    override fun mapToRestModel(obj: District) = DistrictRestModel(
        id = obj.id,
        name = obj.name,
        cityId = obj.cityId
    )

    override fun mapToEntity(obj: DistrictRestModel) = District(
        id = obj.id,
        name = obj.name,
        cityId = obj.cityId
    )
}