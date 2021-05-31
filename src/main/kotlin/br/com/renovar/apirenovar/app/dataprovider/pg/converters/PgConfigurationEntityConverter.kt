package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityDistrictEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgConfigurationModel
import br.com.renovar.apirenovar.domain.pg.entity.PgConfiguration
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgConfigurationEntityConverter constructor(
    private val cityDistrictEntityConverter: CityDistrictEntityConverter
) : EntityConverter<PgConfigurationModel, PgConfiguration> {
    override fun mapToModel(obj: PgConfiguration) = PgConfigurationModel(
        id = obj.id,
        address = obj.address,
        dayOfWeek = obj.dayOfWeek,
        imageId = obj.imageId,
        pg = null,
        district = cityDistrictEntityConverter.mapToModel(obj.district)
    )

    override fun mapToEntity(obj: PgConfigurationModel) = PgConfiguration(
        id = obj.id,
        address = obj.address,
        dayOfWeek = obj.dayOfWeek,
        imageId = obj.imageId,
        pg = null,
        district = cityDistrictEntityConverter.mapToEntity(obj.district)
    )
}