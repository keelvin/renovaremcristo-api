package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgAuthResponseRestModel
import br.com.renovar.apirenovar.domain.pg.entity.PgAuth
import br.com.renovar.apirenovar.domain.pg.entity.PgAuthResponse
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthResponseRestConverter: RestConverter<PgAuthResponseRestModel, PgAuthResponse> {
    override fun mapToRestModel(obj: PgAuthResponse) = PgAuthResponseRestModel(
        token = obj.token,
        pgId = obj.pgId
    )

    override fun mapToEntity(obj: PgAuthResponseRestModel) = PgAuthResponse(
        token = obj.token,
        pgId = obj.pgId
    )
}