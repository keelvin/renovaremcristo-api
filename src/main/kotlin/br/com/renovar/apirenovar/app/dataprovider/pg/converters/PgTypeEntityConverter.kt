package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgTypeModel
import br.com.renovar.apirenovar.domain.pg.entity.PgType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgTypeEntityConverter : EntityConverter<PgTypeModel, PgType> {
    override fun mapToModel(obj: PgType) = PgTypeModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgTypeModel) = PgType(
        id = obj.id,
        description = obj.description
    )
}