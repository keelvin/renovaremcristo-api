package br.com.renovar.apirenovar.app.dataprovider.pg

import br.com.renovar.apirenovar.app.dataprovider.pg.converters.PgMemberEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.pg.repository.PgMemberRepository
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgMemberProvider constructor(
    private val pgMemberRepository: PgMemberRepository,
    private val pgMemberEntityConverter: PgMemberEntityConverter
): PgMemberDataProvider {
    override fun findAllPgsByPersonId(personId: Long) = pgMemberRepository.findAllByPersonId(personId).map {
        pgMemberEntityConverter.mapToEntity(it)
    }

    override fun findAllMembersByPgId(pgId: Long) = pgMemberRepository.findAlLByPgIdOrderByPersonNameAsc(pgId).map {
        pgMemberEntityConverter.mapToEntity(it)
    }

    override fun findMemberByEmailOrPhone(email: String, phone: String) = pgMemberRepository.findMemberByEmailOrPhone(email, phone)?.let {
        pgMemberEntityConverter.mapToEntity(it)
    }

    override fun findMemberByPhone(phone: String) = pgMemberRepository.findMemberByPhone(phone)?.let {
        pgMemberEntityConverter.mapToEntity(it)
    }

    override fun findMemberByEmail(email: String) = pgMemberRepository.findMemberByEmail(email)?.let {
        pgMemberEntityConverter.mapToEntity(it)
    }

    override fun save(obj: PgMember) = pgMemberEntityConverter.mapToEntity(
        pgMemberRepository.save(pgMemberEntityConverter.mapToModel(obj))
    )

    override fun findById(id: Long) = pgMemberRepository.findById(id).orElse(null)?.let {
        pgMemberEntityConverter.mapToEntity(it)
    }
}