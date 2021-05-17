package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.entity.City

interface FindCityByIdUseCase {
    fun execute(id: Long): City?
}