package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgMemberCompleteEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.PgMemberRepository
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberProvider constructor(
    private val pgMemberCompleteEntityConverter: PgMemberCompleteEntityConverter,
    private val pgMemberRepository: PgMemberRepository
) : PgMemberDataProvider {
    override fun findAlLByPgIdOrderByPersonNameAsc(pgId: Long) = pgMemberRepository.findAlLByPgIdOrderByPersonNameAsc(
        pgId
    ).map { pgMemberCompleteEntityConverter.mapToEntity(it) }

    override fun findAllByPersonId(personId: Long) = pgMemberRepository.findAllByPersonId(personId).map {
        pgMemberCompleteEntityConverter.mapToEntity(it)
    }

    override fun findAll() = pgMemberRepository.findAll().map { pgMemberCompleteEntityConverter.mapToEntity(it) }

    override fun findById(id: Long) = pgMemberRepository.findById(id).orElse(null)?.let {
        return@let pgMemberCompleteEntityConverter.mapToEntity(it)
    }

    override fun save(obj: PgMember) = pgMemberCompleteEntityConverter.mapToEntity(
        pgMemberRepository.save(pgMemberCompleteEntityConverter.mapToModel(obj))
    )

}