package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.NetworkBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.Network
import br.com.renovar.apirenovar.repositories.NetworkRepository
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
@RequestMapping("/api/network")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkRestController(@Autowired private val business: NetworkBusiness) : BaseRestController<Network, Long, NetworkRepository, NetworkBusiness>(business) {

    @GetMapping(value = ["/actives/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByActive() = ResponseEntity<ResponseData<List<Network>>>(
        ResponseData.success(this.business.findAllByActiveIsTrue()), HttpStatus.OK)

    @GetMapping(value = ["/actives/leader/{leaderId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByLeaderAndActive(@PathVariable("leaderId") leaderId: Long) = ResponseEntity<ResponseData<List<Network>>>(
        ResponseData.success(this.business.findAllByLeaderIdAndActiveIsTrue(leaderId)), HttpStatus.OK
    )

    @GetMapping(value = ["/leader/{leaderId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByLeaderId(@PathVariable("leaderId") leaderId: Long) = ResponseEntity<ResponseData<List<Network>>>(
        ResponseData.success(this.business.findAllByLeaderId(leaderId)), HttpStatus.OK
    )

}