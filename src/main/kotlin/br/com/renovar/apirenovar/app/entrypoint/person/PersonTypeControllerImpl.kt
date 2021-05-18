package br.com.renovar.apirenovar.app.entrypoint.person

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.person.converters.PersonTypeRestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonTypeRestModel
import br.com.renovar.apirenovar.domain.person.usecase.FindAllPersonTypesUseCase
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/person-type")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonTypeControllerImpl constructor(
    private val personTypeRestConverter: PersonTypeRestConverter,
    private val findAllPersonTypesUseCase: FindAllPersonTypesUseCase
) : PersonTypeController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<PersonTypeRestModel>>> {
        return ResponseEntity(
            ResponseData.success(findAllPersonTypesUseCase.execute().map { personTypeRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

}