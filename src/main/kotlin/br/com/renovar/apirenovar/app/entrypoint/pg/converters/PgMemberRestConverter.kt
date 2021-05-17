package br.com.renovar.apirenovar.app.entrypoint.pg.converters

import br.com.renovar.apirenovar.app.commons.RestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.converters.PersonRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.PgMemberRestModel
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberRestConverter @Autowired constructor(
    private val personRestConverter: PersonRestConverter,
    private val pgMemberTypeRestConverter: PgMemberTypeRestConverter
) : RestConverter<PgMemberRestModel, PgMember> {
    override fun mapToRestModel(obj: PgMember) = PgMemberRestModel(
        id = obj.id,
        pg = null,
        pgId = obj.pgId,
        person = personRestConverter.mapToRestModel(obj.person),
        type = pgMemberTypeRestConverter.mapToRestModel(obj.type),
        registeredAt = obj.registeredAt
    )

    override fun mapToEntity(obj: PgMemberRestModel) = PgMember(
        id = obj.id,
        pg = null,
        pgId = obj.pgId,
        person = personRestConverter.mapToEntity(obj.person),
        type = pgMemberTypeRestConverter.mapToEntity(obj.type),
        registeredAt = obj.registeredAt
    )
}