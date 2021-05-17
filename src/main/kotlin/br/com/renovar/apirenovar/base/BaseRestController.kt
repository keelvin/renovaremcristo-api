package br.com.renovar.apirenovar.base

import br.com.renovar.apirenovar.configurations.AppCommons
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

abstract class BaseRestController<T: BaseEntity, ID: Any, R: BaseRepository<T, ID>, B: BaseBusiness<T, ID, R>>(private val business: B) {

    @GetMapping(value = ["/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findById(@PathVariable("id") id: ID): ResponseEntity<ResponseData<T>> {
        val obj = this.business.findById(id)

        return if (obj == null) {
            ResponseEntity(ResponseData.failure("Não localizado registro com o id informado"), HttpStatus.OK)
        } else {
            ResponseEntity(ResponseData.success(obj), HttpStatus.OK)
        }
    }

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun findAll(): ResponseEntity<ResponseData<List<T>>> {
        val objs = this.business.findAll()

        return ResponseEntity(ResponseData.success(objs), HttpStatus.OK)
    }

    @PostMapping(value = ["/"], consumes = [AppCommons.APPLICATION_JSON_UTF8], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun save(@RequestBody body: T): ResponseEntity<ResponseData<T>> {
        val response = this.business.save(body)

        return ResponseEntity(response, if (response.successful)  HttpStatus.CREATED else HttpStatus.BAD_REQUEST)
    }

    @PutMapping(value = ["/"], consumes = [AppCommons.APPLICATION_JSON_UTF8], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun update(@RequestBody body: T): ResponseEntity<ResponseData<T>> {
        val response = this.business.save(body)

        return ResponseEntity(response, if (response.successful) HttpStatus.OK else HttpStatus.BAD_REQUEST)
    }

    @DeleteMapping(value = ["/"], consumes = [AppCommons.APPLICATION_JSON_UTF8], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun delete(@RequestBody body: T): ResponseEntity<ResponseData<Boolean>> {
        return if (this.business.delete(body)) {
            ResponseEntity(ResponseData.success(true), HttpStatus.OK)
        } else {
            ResponseEntity(ResponseData.failure("Não foi possível deletar o registro"), HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping(value = ["/{id}"], consumes = [AppCommons.APPLICATION_JSON_UTF8], produces = [AppCommons.APPLICATION_JSON_UTF8])
    fun delete(@PathVariable("id") id: ID): ResponseEntity<ResponseData<Boolean>> {
        return if (this.business.deleteById(id)) {
            ResponseEntity(ResponseData.success(true), HttpStatus.OK)
        } else {
            ResponseEntity(ResponseData.failure("Não foi possível deletar o registro"), HttpStatus.BAD_REQUEST)
        }
    }


}