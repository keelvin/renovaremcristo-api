package br.com.renovar.apirenovar.domain.city.dataprovider

import br.com.renovar.apirenovar.domain.city.entity.City

interface CityDataProvider {
    //fun save(city: City): City
    fun findById(id: Long): City?
    fun findAll() : List<City>
    fun filterByName(filter: String): List<City>
}