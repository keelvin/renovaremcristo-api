package br.com.renovar.apirenovar.domain.city.usecase

import br.com.renovar.apirenovar.domain.city.entity.District

interface FindAllDistrictsByCityIdUseCase {
    fun execute(cityId: Long): List<District>
}