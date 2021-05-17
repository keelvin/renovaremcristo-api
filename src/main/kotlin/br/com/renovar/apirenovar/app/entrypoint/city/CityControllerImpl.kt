package br.com.renovar.apirenovar.app.entrypoint.city

import br.com.renovar.apirenovar.app.entrypoint.city.converters.CityRestConverter
import br.com.renovar.apirenovar.app.entrypoint.city.models.CityRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.city.usecase.FilterCityByNameUseCase
import br.com.renovar.apirenovar.domain.city.usecase.FindAllCitiesUseCase
import br.com.renovar.apirenovar.domain.city.usecase.FindCityByIdUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/city")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CityControllerImpl @Autowired constructor(
    private val findAllCitiesUseCase: FindAllCitiesUseCase,
    private val findCityByIdUseCase: FindCityByIdUseCase,
    private val filterCityByNameUseCase: FilterCityByNameUseCase,
    private val cityRestConverter: CityRestConverter
) : CityController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<CityRestModel>>> {
        val objs = findAllCitiesUseCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { cityRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findById(@PathVariable("id") id: Long): ResponseEntity<ResponseData<CityRestModel>> {
        val obj = findCityByIdUseCase.execute(id)

        val responseData: ResponseData<CityRestModel> = if (obj == null) ResponseData.failure("Não localizado registro com o código informado")
            else ResponseData.success(cityRestConverter.mapToRestModel(obj))

        return ResponseEntity(responseData, HttpStatus.OK)

    }

    @GetMapping(value = ["/filter/{name}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun filterByName(@PathVariable("name") name: String): ResponseEntity<ResponseData<List<CityRestModel>>> {
        val objs = filterCityByNameUseCase.execute(name)

        return ResponseEntity(
            ResponseData.success(objs.map { cityRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }
}