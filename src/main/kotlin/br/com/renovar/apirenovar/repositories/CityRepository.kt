package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.City
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : BaseRepository<City, Long> {
    fun findAllByNameIgnoreCaseContains(filter: String): List<City>
}

