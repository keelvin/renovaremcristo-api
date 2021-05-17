package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.CityBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.City
import br.com.renovar.apirenovar.repositories.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/city")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityRestController(@Autowired private val business: CityBusiness) : BaseRestController<City, Long, CityRepository, CityBusiness>(business) {

    @GetMapping(value = ["/filter/{filter}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun filterCityByName(@PathVariable("filter") filter: String) = ResponseEntity<ResponseData<List<City>>>(
        ResponseData.success(this.business.findAllByNameIgnoreCaseContains(filter)), HttpStatus.OK
    )

}