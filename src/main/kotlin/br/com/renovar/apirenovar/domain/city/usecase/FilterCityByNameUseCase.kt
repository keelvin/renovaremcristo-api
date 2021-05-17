package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.entity.City

interface FilterCityByNameUseCase {
    fun execute(filter: String): List<City>
}