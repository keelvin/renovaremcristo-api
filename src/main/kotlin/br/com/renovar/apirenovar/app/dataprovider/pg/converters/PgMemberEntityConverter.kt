package br.com.renovar.apirenovar.app.dataprovider.pg.converters

import br.com.renovar.apirenovar.app.commons.EntityConverter
import br.com.renovar.apirenovar.app.dataprovider.person.converters.PersonEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberModel
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberEntityConverter @Autowired constructor(
    private val personEntityConverter: PersonEntityConverter,
    private val pgMemberTypeEntityConverter: PgMemberTypeEntityConverter
) : EntityConverter<PgMemberModel, PgMember> {
    override fun mapToModel(obj: PgMember) = PgMemberModel(
        id = obj.id,
        pg = null,
        pgId = obj.pgId,
        person = personEntityConverter.mapToModel(obj.person),
        type = pgMemberTypeEntityConverter.mapToModel(obj.type),
        registeredAt = obj.registeredAt
    )

    override fun mapToEntity(obj: PgMemberModel) = PgMember(
        id = obj.id,
        pg = null,
        pgId = obj.pgId,
        person = personEntityConverter.mapToEntity(obj.person),
        type = pgMemberTypeEntityConverter.mapToEntity(obj.type),
        registeredAt = obj.registeredAt
    )
}