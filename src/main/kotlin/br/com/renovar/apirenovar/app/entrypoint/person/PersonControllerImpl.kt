package br.com.renovar.apirenovar.app.entrypoint.person

import br.com.renovar.apirenovar.app.entrypoint.person.converters.PersonRestConverter
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.person.usecase.FindAllPersonUserCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/person")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonControllerImpl @Autowired constructor(
    private val findAllPersonUserCase: FindAllPersonUserCase,
    private val personRestConverter: PersonRestConverter
) : PersonController {

    @GetMapping(value = ["/actives/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllActives(): ResponseEntity<ResponseData<List<PersonRestModel>>> {
        val objs = findAllPersonUserCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { personRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

}