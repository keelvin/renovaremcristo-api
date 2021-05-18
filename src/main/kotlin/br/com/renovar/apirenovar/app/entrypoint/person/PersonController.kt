package br.com.renovar.apirenovar.app.entrypoint.person

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.person.models.PersonRestModel
import org.springframework.http.ResponseEntity

interface PersonController: BaseRestController<PersonRestModel, Long> {
    fun findAllActives(): ResponseEntity<ResponseData<List<PersonRestModel>>>
}