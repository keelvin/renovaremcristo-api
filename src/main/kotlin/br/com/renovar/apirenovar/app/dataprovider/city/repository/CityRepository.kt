package br.com.renovar.apirenovar.app.dataprovider.city.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : BaseRepository<CityModel, Long> {
    fun findAllByNameIgnoreCaseContainsOrderByNameAsc(filter: String): List<CityModel>
    fun findAllByOrderByNameAsc(): List<CityModel>
}

