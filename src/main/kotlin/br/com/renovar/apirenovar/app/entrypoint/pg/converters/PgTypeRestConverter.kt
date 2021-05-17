package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgTypeRestModel
import br.com.renovar.apirenovar.domain.pg.entity.PgType
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgTypeRestConverter : RestConverter<PgTypeRestModel, PgType> {
    override fun mapToRestModel(obj: PgType) = PgTypeRestModel(
        id = obj.id,
        description = obj.description
    )

    override fun mapToEntity(obj: PgTypeRestModel) = PgType(
        id = obj.id,
        description = obj.description
    )
}