package br.com.renovar.apirenovar.app.dataprovider.church.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.church.model.ChurchModel
import br.com.renovar.apirenovar.app.dataprovider.city.converters.CityEntityConverter
import br.com.renovar.apirenovar.domain.church.entity.Church
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchEntityConverter : EntityConverter<ChurchModel, Church> {
    @Autowired
    private lateinit var cityEntityConverter: CityEntityConverter

    override fun mapToModel(obj: Church) = ChurchModel(
        id = obj.id,
        name = obj.name,
        cnpj = obj.cnpj,
        email = obj.email,
        phone = obj.phone,
        pastorName = obj.pastorName,
        address = obj.address,
        city = cityEntityConverter.mapToModel(obj.city)
    )

    override fun mapToEntity(obj: ChurchModel) = Church(
        id = obj.id,
        name = obj.name,
        cnpj = obj.cnpj,
        email = obj.email,
        phone = obj.phone,
        pastorName = obj.pastorName,
        address = obj.address,
        city = cityEntityConverter.mapToEntity(obj.city)
    )
}