package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.entity.District

interface FindAllDistrictsByNameAndCityIdUseCase {
    fun execute(name: String, cityId: Long): List<District>
}