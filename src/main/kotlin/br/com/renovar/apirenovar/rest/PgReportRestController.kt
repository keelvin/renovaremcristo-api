package br.com.renovar.apirenovar.rest

import br.com.renovar.apirenovar.base.BaseRestController
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.business.PgReportBusiness
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.entities.PgReport
import br.com.renovar.apirenovar.repositories.PgReportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/report")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportRestController(@Autowired private val business: PgReportBusiness) :
        BaseRestController<PgReport, Long, PgReportRepository, PgReportBusiness>(business) {

    @GetMapping(value = ["/pg/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByPgId(@PathVariable("id") pgId: Long) = ResponseEntity<ResponseData<List<PgReport>>>(
        ResponseData.success(this.business.findAllByPgId(pgId)), HttpStatus.OK
    )

    @GetMapping(value = ["/initialDate/{initialDate}/finalDate/{finalDate}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByDateBetween(@PathVariable("initialDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) initialDate: Date,
        @PathVariable("finalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) finalDate: Date) = ResponseEntity<ResponseData<List<PgReport>>>(

        ResponseData.success(this.business.findAllByDateBetween(initialDate, finalDate)), HttpStatus.OK
    )

    @GetMapping(value = ["/pg/{id}/initialDate/{initialDate}/finalDate/{finalDate}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByPgIdAndDateBetween(@PathVariable("id") pgId: Long,
                                    @PathVariable("initialDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) initialDate: Date,
                                    @PathVariable("finalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) finalDate: Date) = ResponseEntity<ResponseData<List<PgReport>>>(
        ResponseData.success(this.business.findAllByPgIdAndDateBetween(pgId, initialDate, finalDate)),
            HttpStatus.OK
    )

    @GetMapping(value = ["/pg/{id}/orderByDate"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAllByPgIdOrderByDateDesc(@PathVariable("id") pgId: Long) = ResponseEntity<ResponseData<List<PgReport>>> (
        ResponseData.success(this.business.findAllByPgIdOrderByDateDesc(pgId)), HttpStatus.OK
    )


}