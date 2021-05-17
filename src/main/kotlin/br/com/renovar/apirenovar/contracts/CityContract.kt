package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.City

interface CityContract : BaseContract<City, Long> {
    fun findAllByNameIgnoreCaseContains(filter: String): List<City>
}