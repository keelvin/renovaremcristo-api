package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.PersonBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.Person
import br.com.renovar.apirenovar.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonRestController(@Autowired private val business: PersonBusiness) : BaseRestController<Person, Long, PersonRepository, PersonBusiness>(business) {
    @GetMapping(value = ["/actives/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByActiveIsTrue(): ResponseEntity<ResponseData<List<Person>>> {
        val objs = this.business.findAllByActiveIsTrue()

        return ResponseEntity(ResponseData.success(objs), HttpStatus.OK)
    }

    @GetMapping(value = ["/email/{email}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findByEmail(@PathVariable("email") email: String): ResponseEntity<ResponseData<Person>> {
        val obj = this.business.findByEmail(email)

        return if (obj == null) {
            ResponseEntity(ResponseData.failure("Não localizado registro com o email informado"), HttpStatus.OK)
        } else {
            ResponseEntity(ResponseData.success(obj), HttpStatus.OK)
        }
    }

    @GetMapping(value = ["/actives/email/{email}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findByEmailAndActive(@PathVariable("email") email: String): ResponseEntity<ResponseData<Person>> {
        val obj = this.business.findByEmailAndActiveIsTrue(email)

        return if (obj == null) {
            ResponseEntity(ResponseData.failure("Não localizado registro ativo com o email informado"), HttpStatus.OK)
        } else {
            ResponseEntity(ResponseData.success(obj), HttpStatus.OK)
        }
    }

    @GetMapping(value = ["/actives/church/{churchId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchIdAndActive(@PathVariable("churchId") churchId: Long): ResponseEntity<ResponseData<List<Person>>> {
        val objs = this.business.findAllByChurchIdAndActiveIsTrue(churchId)

        return ResponseEntity(ResponseData.success(objs), HttpStatus.OK)
    }

    @GetMapping(value = ["/actives/church/{churchId}/type/{personType}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchIdAndActiveAndPersonTypeId(@PathVariable("churchId") churchId: Long,
                                                  @PathVariable("personType") personType: Long): ResponseEntity<ResponseData<List<Person>>> {
        val objs = this.business.findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId, personType)

        return ResponseEntity(ResponseData.success(objs), HttpStatus.OK)
    }

    @GetMapping(value = ["/actives/type/{personType}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByActiveAndPersonTypeId(@PathVariable("personType") personType: Long): ResponseEntity<ResponseData<List<Person>>> {
        val objs = this.business.findAllByActiveIsTrueAndPersonTypeId(personType)

        return ResponseEntity(ResponseData.success(objs), HttpStatus.OK)
    }

}
