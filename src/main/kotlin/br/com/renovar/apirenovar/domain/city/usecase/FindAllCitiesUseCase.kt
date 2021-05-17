package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.entity.City

interface FindAllCitiesUseCase {
    fun execute() : List<City>
}