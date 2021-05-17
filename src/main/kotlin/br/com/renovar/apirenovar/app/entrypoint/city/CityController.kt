package br.com.renovar.apirenovar.app.entrypoint.city

import br.com.renovar.apirenovar.app.entrypoint.city.models.CityRestModel
import br.com.renovar.apirenovar.base.ResponseData
import org.springframework.http.ResponseEntity

interface CityController {
    fun findAll(): ResponseEntity<ResponseData<List<CityRestModel>>>
    fun findById(id: Long): ResponseEntity<ResponseData<CityRestModel>>
    fun filterByName(name: String): ResponseEntity<ResponseData<List<CityRestModel>>>
}