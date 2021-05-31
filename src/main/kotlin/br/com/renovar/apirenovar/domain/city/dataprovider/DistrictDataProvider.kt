package br.com.renovar.apirenovar.domain.city.dataprovider

import br.com.renovar.apirenovar.domain.city.entity.District
import br.com.renovar.apirenovar.domain.commons.DataProvider

interface DistrictDataProvider: DataProvider<District> {
    fun findAllByCityId(cityId: Long): List<District>
    fun filterByNameAndCityId(name: String, cityId: Long): List<District>
}