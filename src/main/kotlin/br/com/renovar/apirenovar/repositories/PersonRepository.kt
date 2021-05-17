package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.Person
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : BaseRepository<Person, Long> {
    fun findAllByActiveIsTrue(): List<Person>
    fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<Person>
    fun findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId: Long, personTypeId: Long): List<Person>
    fun findAllByActiveIsTrueAndPersonTypeId(personTypeId: Long): List<Person>
    fun findByEmail(email: String): Person?
    fun findByEmailAndActiveIsTrue(email: String): Person?
}
