package br.com.renovar.apirenovar.app.dataprovider.city.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityDistrictModel
import br.com.renovar.apirenovar.domain.city.entity.District
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityDistrictEntityConverter : EntityConverter<CityDistrictModel, District> {
    override fun mapToModel(obj: District) = CityDistrictModel(
        id = obj.id,
        name = obj.name,
        cityId = obj.cityId
    )

    override fun mapToEntity(obj: CityDistrictModel) = District(
        id = obj.id,
        name = obj.name,
        cityId = obj.cityId
    )
}