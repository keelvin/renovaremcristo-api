package br.com.renovar.apirenovar.app.dataprovider.city.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityDistrictModel
import org.springframework.stereotype.Repository

@Repository
interface CityDistrictRepository : BaseRepository<CityDistrictModel, Long> {
    fun findAllByCityIdOrderByNameAsc(cityId: Long): List<CityDistrictModel>
    fun findAllByNameAndCityIdOrderByNameAsc(name: String, cityId: Long): List<CityDistrictModel>
}