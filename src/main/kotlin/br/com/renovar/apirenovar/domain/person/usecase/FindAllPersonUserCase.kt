package br.com.renovar.apirenovar.domain.person.usecase

import br.com.renovar.apirenovar.domain.person.entity.Person

interface FindAllPersonUserCase {
    fun execute(): Collection<Person>
}