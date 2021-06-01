package br.com.renovar.apirenovar.app.entrypoint.city

import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityRestModel
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityWithoutDistrictsRestModel
import org.springframework.http.ResponseEntity

interface CityController {
    fun findAll(): ResponseEntity<ResponseData<List<CityWithoutDistrictsRestModel>>>
    fun findById(id: Long): ResponseEntity<ResponseData<CityRestModel>>
    fun filterByName(name: String): ResponseEntity<ResponseData<List<CityWithoutDistrictsRestModel>>>
}