package br.com.renovar.apirenovar.domain.person.dataprovider

import br.com.renovar.apirenovar.domain.person.entity.Person

interface PersonDataProvider {
    fun findAllActives(): Collection<Person>
}