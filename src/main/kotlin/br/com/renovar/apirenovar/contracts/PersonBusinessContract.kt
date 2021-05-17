package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.Person

interface PersonBusinessContract : BaseContract<Person, Long> {
    fun findAllByActiveIsTrue(): List<Person>
    fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<Person>
    fun findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId: Long, personTypeId: Long): List<Person>
    fun findAllByActiveIsTrueAndPersonTypeId(personTypeId: Long): List<Person>
    fun findByEmail(email: String): Person?
    fun findByEmailAndActiveIsTrue(email: String): Person?
}
