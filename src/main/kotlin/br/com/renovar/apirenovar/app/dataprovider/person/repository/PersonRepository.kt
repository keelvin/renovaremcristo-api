package br.com.renovar.apirenovar.app.dataprovider.person.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonModel
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : BaseRepository<PersonModel, Long> {
    fun findAllByActiveIsTrue(): Collection<PersonModel>
    fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<PersonModel>
    fun findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId: Long, personTypeId: Long): List<PersonModel>
    fun findAllByActiveIsTrueAndPersonTypeId(personTypeId: Long): List<PersonModel>
    fun findByEmail(email: String): PersonModel?
    fun findByEmailAndActiveIsTrue(email: String): PersonModel?
}
