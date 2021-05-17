package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.AuthBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.dtos.AuthResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/security")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class AuthRestController {

    @Autowired
    private lateinit var authBusiness: AuthBusiness

    @GetMapping(value = ["/authenticate"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun authenticate(@RequestHeader("login") login: String,
                     @RequestHeader("password") password: String) : ResponseEntity<ResponseData<AuthResponseDto>> {
        return ResponseEntity(
            this.authBusiness.authenticate(login, password),
            HttpStatus.OK
        )
    }

}