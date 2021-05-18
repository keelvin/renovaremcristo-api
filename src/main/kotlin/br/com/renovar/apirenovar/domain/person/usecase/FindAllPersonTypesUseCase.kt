package br.com.renovar.apirenovar.domain.person.usecase

import br.com.renovar.apirenovar.domain.person.entity.PersonType

interface FindAllPersonTypesUseCase {
    fun execute(): List<PersonType>
}