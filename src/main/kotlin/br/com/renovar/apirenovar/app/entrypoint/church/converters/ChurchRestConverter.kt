package br.com.renovar.apirenovar.app.entrypoint.church.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.church.models.ChurchRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.converters.CityWithoutDistrictsRestConverter
import br.com.renovar.apirenovar.domain.church.entity.Church
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchRestConverter @Autowired constructor(
    private val cityWithoutDistrictsRestConverter: CityWithoutDistrictsRestConverter,
) : RestConverter<ChurchRestModel, Church> {
    override fun mapToRestModel(obj: Church) = ChurchRestModel(
        id = obj.id,
        name = obj.name,
        cnpj = obj.cnpj,
        email = obj.email,
        phone = obj.phone,
        address = obj.address,
        city = cityWithoutDistrictsRestConverter.mapToRestModel(obj.city)
    )

    override fun mapToEntity(obj: ChurchRestModel) = Church(
        id = obj.id,
        name = obj.name,
        cnpj = obj.cnpj,
        email = obj.email,
        phone = obj.phone,
        address = obj.address,
        city = cityWithoutDistrictsRestConverter.mapToEntity(obj.city)
    )
}