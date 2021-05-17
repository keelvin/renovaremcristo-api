package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.church.converters.ChurchEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgModel
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgEntityConverter @Autowired constructor(
    private val networkEntityConverter: NetworkEntityConverter,
    private val churchEntityConverter: ChurchEntityConverter,
    private val cityEntityConverter: CityEntityConverter,
    private val pgTypeEntityConverter: PgTypeEntityConverter,
    private val pgConfigurationEntityConverter: PgConfigurationEntityConverter,
    private val pgMemberEntityConverter: PgMemberEntityConverter
) : EntityConverter<PgModel, Pg> {
    override fun mapToModel(obj: Pg) = PgModel(
        id = obj.id,
        name = obj.name,
        network = networkEntityConverter.mapToModel(obj.network),
        church = churchEntityConverter.mapToModel(obj.church),
        city = cityEntityConverter.mapToModel(obj.city),
        pgType = pgTypeEntityConverter.mapToModel(obj.pgType),
        configuration = pgConfigurationEntityConverter.mapToModel(obj.configuration),
        members = obj.members.map { pgMemberEntityConverter.mapToModel(it) }.toMutableList(),
        active = obj.active
    )

    override fun mapToEntity(obj: PgModel) = Pg(
        id = obj.id,
        name = obj.name,
        network = networkEntityConverter.mapToEntity(obj.network),
        church = churchEntityConverter.mapToEntity(obj.church),
        city = cityEntityConverter.mapToEntity(obj.city),
        pgType = pgTypeEntityConverter.mapToEntity(obj.pgType),
        configuration = pgConfigurationEntityConverter.mapToEntity(obj.configuration),
        members = obj.members.map { pgMemberEntityConverter.mapToEntity(it) }.toMutableList(),
        active = obj.active
    )
}