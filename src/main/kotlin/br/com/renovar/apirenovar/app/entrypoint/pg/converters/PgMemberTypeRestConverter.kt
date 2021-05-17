package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberTypeRestModel
import br.com.renovar.apirenovar.domain.pg.entity.PgMemberType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberTypeRestConverter : RestConverter<PgMemberTypeRestModel, PgMemberType> {
    override fun mapToRestModel(obj: PgMemberType) = PgMemberTypeRestModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgMemberTypeRestModel) = PgMemberType(
        id = obj.id,
        description = obj.description
    )
}