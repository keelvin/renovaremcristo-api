package br.com.renovar.apirenovar.app.entrypoint.city

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.city.converters.DistrictRestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.DistrictRestModel
import br.com.renovar.apirenovar.domain.city.usecase.FindAllDistrictsByCityIdUseCase
import br.com.renovar.apirenovar.domain.city.usecase.FindAllDistrictsByNameAndCityIdUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/district")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityDistrictControllerImpl constructor(
    private val converter: DistrictRestConverter,
    private val findAllDistrictsByCityIdUseCase: FindAllDistrictsByCityIdUseCase,
    private val findAllDistrictsByNameAndCityIdUseCase: FindAllDistrictsByNameAndCityIdUseCase
): CityDistrictController {

    @GetMapping(value = ["/city/{cityId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllCityId(@PathVariable("cityId") cityId: Long): ResponseEntity<ResponseData<List<DistrictRestModel>>> {
        val objs = findAllDistrictsByCityIdUseCase.execute(cityId)

        return ResponseEntity(
            ResponseData.success(objs.map { converter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/{name}/city/{cityId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByNameAndCityId(
        @PathVariable("name") name: String,
        @PathVariable("cityId") cityId: Long
    ): ResponseEntity<ResponseData<List<DistrictRestModel>>> {
        val objs = findAllDistrictsByNameAndCityIdUseCase.execute(name, cityId)

        return ResponseEntity(
            ResponseData.success(objs.map { converter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }
}