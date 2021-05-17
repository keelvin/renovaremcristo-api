package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.commons.BaseRestController
import br.com.renovar.apirenovar.app.entrypoint.pg.models.NetworkRestModel
import br.com.renovar.apirenovar.base.ResponseData
import org.springframework.http.ResponseEntity

interface NetworkController: BaseRestController<NetworkRestModel, Long> {
    fun findAllByLeaderIdAndActiveIsTrue(leaderId: Long): ResponseEntity<ResponseData<List<NetworkRestModel>>>
    fun findAllByActiveIsTrue(): ResponseEntity<ResponseData<List<NetworkRestModel>>>
    fun findAllByLeaderId(leaderId: Long): ResponseEntity<ResponseData<List<NetworkRestModel>>>
}