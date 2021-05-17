package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgConfigurationRestModel
import br.com.renovar.apirenovar.domain.pg.entity.PgConfiguration
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgConfigurationRestConverter : RestConverter<PgConfigurationRestModel, PgConfiguration> {
    override fun mapToRestModel(obj: PgConfiguration) = PgConfigurationRestModel(
        id = obj.id,
        dayOfWeek = obj.dayOfWeek,
        address = obj.address,
        imageId = obj.imageId
    )

    override fun mapToEntity(obj: PgConfigurationRestModel) = PgConfiguration(
        id = obj.id,
        dayOfWeek = obj.dayOfWeek,
        address = obj.address,
        imageId = obj.address,
        pg = null
    )
}