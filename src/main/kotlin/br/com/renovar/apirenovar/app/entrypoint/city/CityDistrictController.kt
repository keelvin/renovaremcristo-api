package br.com.renovar.apirenovar.app.entrypoint.city

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.city.models.DistrictRestModel
import org.springframework.http.ResponseEntity

interface CityDistrictController : BaseRestController<DistrictRestModel, Long> {
    fun findAllCityId(cityId: Long): ResponseEntity<ResponseData<List<DistrictRestModel>>>
    fun findAllByNameAndCityId(name: String, cityId: Long): ResponseEntity<ResponseData<List<DistrictRestModel>>>
}