package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.church.converters.ChurchRestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.converters.CityWithoutDistrictsRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgRestModel
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgRestConverter @Autowired constructor(
    private val networkRestConverter: NetworkRestConverter,
    private val churchRestConverter: ChurchRestConverter,
    private val cityWithoutDistrictsRestConverter: CityWithoutDistrictsRestConverter,
    private val pgTypeRestConverter: PgTypeRestConverter,
    private val pgConfigurationRestConverter: PgConfigurationRestConverter,
    private val pgMemberRestConverter: PgMemberRestConverter
) : RestConverter<PgRestModel, Pg> {
    override fun mapToRestModel(obj: Pg) = PgRestModel(
        id = obj.id,
        name = obj.name,
        network = networkRestConverter.mapToRestModel(obj.network),
        church = churchRestConverter.mapToRestModel(obj.church),
        city = cityWithoutDistrictsRestConverter.mapToRestModel(obj.city),
        pgType = pgTypeRestConverter.mapToRestModel(obj.pgType),
        configuration = pgConfigurationRestConverter.mapToRestModel(obj.configuration),
        members = obj.members.map { pgMemberRestConverter.mapToRestModel(it) }.toMutableList(),
        active = obj.active
    )

    override fun mapToEntity(obj: PgRestModel) = Pg(
        id = obj.id,
        name = obj.name,
        network = networkRestConverter.mapToEntity(obj.network),
        church = churchRestConverter.mapToEntity(obj.church),
        city = cityWithoutDistrictsRestConverter.mapToEntity(obj.city),
        pgType = pgTypeRestConverter.mapToEntity(obj.pgType),
        configuration = pgConfigurationRestConverter.mapToEntity(obj.configuration),
        members = obj.members.map { pgMemberRestConverter.mapToEntity(it) }.toMutableList(),
        active = obj.active
    )
}