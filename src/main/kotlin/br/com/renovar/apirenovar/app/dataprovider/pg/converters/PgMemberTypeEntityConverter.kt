package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberTypeModel
import br.com.renovar.apirenovar.domain.pg.entity.PgMemberType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeEntityConverter : EntityConverter<PgMemberTypeModel, PgMemberType> {
    override fun mapToModel(obj: PgMemberType) = PgMemberTypeModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgMemberTypeModel) = PgMemberType(
        id = obj.id,
        description = obj.description
    )
}