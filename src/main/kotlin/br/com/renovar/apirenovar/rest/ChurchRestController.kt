package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.ChurchBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.Church
import br.com.renovar.apirenovar.repositories.ChurchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/church")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchRestController(@Autowired private val business: ChurchBusiness) : BaseRestController<Church, Long, ChurchRepository, ChurchBusiness>(business) {

    @GetMapping(value = ["/actives"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllActives(): ResponseEntity<ResponseData<List<Church>>> = ResponseEntity(
        ResponseData.success(this.business.findAll()), HttpStatus.OK
    )

}