package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.PgBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.Pg
import br.com.renovar.apirenovar.repositories.PgRepository
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
@RequestMapping("/api/pg")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgRestController(@Autowired private val business: PgBusiness) : BaseRestController<Pg, Long, PgRepository, PgBusiness>(business) {

    @GetMapping(value = ["/actives/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllActive() = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByActiveIsTrue()), HttpStatus.OK
    )

    @GetMapping(value = ["/actives/church/{churchId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndActive(@PathVariable("churchId") churchId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByChurchIdAndActiveIsTrue(churchId)), HttpStatus.OK
    )

    @GetMapping(value = ["/actives/church/{churchId}/network/{networkId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndNetworkAndActive(@PathVariable("churchId") churchId: Long,
                                           @PathVariable("networkId") networkId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByChurchIdAndNetworkIdAndActiveIsTrue(churchId, networkId)), HttpStatus.OK
    )

    @GetMapping(value = ["/actives/church/{churchId}/network/{networkId}/type/{typeId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndNetworkAndPgTypeAndActive(@PathVariable("churchId") churchId: Long,
                                                    @PathVariable("networkId") networkId: Long,
                                                    @PathVariable("typeId") typeId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByPgTypeIdAndChurchIdAndNetworkIdAndActiveIsTrue(typeId, churchId, networkId)),
        HttpStatus.OK
    )

    @GetMapping(value = ["/actives/network/{networkId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByNetworkAndActive(@PathVariable("networkId") networkId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByNetworkIdAndActiveIsTrue(networkId)), HttpStatus.OK
    )

    @GetMapping(value = ["/actives/type/{typeId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByTypeAndActive(@PathVariable("typeId") typeId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByPgTypeIdAndActiveIsTrue(typeId)), HttpStatus.OK
    )


    @GetMapping(value = ["/church/{churchId}/network/{networkId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndNetwork(@PathVariable("churchId") churchId: Long,
                                  @PathVariable("networkId") networkId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByChurchIdAndNetworkId(churchId, networkId)), HttpStatus.OK
    )

    @GetMapping(value = ["/church/{churchId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurch(@PathVariable("churchId") churchId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByChurchId(churchId)), HttpStatus.OK
    )

    @GetMapping(value = ["/church/{churchId}/network/{networkId}/type/{typeId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndNetworkAndPgType(@PathVariable("churchId") churchId: Long,
                                                    @PathVariable("networkId") networkId: Long,
                                                    @PathVariable("typeId") typeId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByPgTypeIdAndChurchIdAndNetworkId(typeId, churchId, networkId)),
        HttpStatus.OK
    )

    @GetMapping(value = ["/network/{networkId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByNetwork(@PathVariable("networkId") networkId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByNetworkId(networkId)), HttpStatus.OK
    )

    @GetMapping(value = ["/network/{networkId}/type/{typeId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByNetworkAndType(@PathVariable("networkId") networkId: Long,
                                @PathVariable("typeId") typeId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByPgTypeIdAndNetworkId(networkId, typeId)), HttpStatus.OK
    )

    @GetMapping(value = ["/church/{churchId}/type/{typeId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByChurchAndType(@PathVariable("churchId") churchId: Long,
                               @PathVariable("typeId") typeId: Long) = ResponseEntity<ResponseData<List<Pg>>>(
        ResponseData.success(this.business.findAllByPgTypeIdAndChurchId(typeId, churchId)), HttpStatus.OK
    )

}