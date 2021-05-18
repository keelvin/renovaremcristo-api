package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgAuthModel
import br.com.renovar.apirenovar.domain.pg.entity.PgAuth
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgAuthEntityConverter : EntityConverter<PgAuthModel, PgAuth> {
    override fun mapToModel(obj: PgAuth) = PgAuthModel(
        login = obj.login,
        password = obj.password,
        pgId = obj.pgId
    )

    override fun mapToEntity(obj: PgAuthModel) = PgAuth(
        login = obj.login,
        password = obj.password,
        pgId = obj.pgId
    )
}