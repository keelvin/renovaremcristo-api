package br.com.renovar.apirenovar.app.commons

import br.com.renovar.apirenovar.base.ResponseData
import org.springframework.http.ResponseEntity

interface BaseRestController<T: BaseRestModel, ID: Any> {
    fun delete(obj: T): ResponseEntity<ResponseData<Boolean>> {
        throw RuntimeException("Não implementado")
    }
    fun deleteById(id: ID): ResponseEntity<ResponseData<Boolean>> {
        throw RuntimeException("Não implementado")
    }
    fun findAll(): ResponseEntity<ResponseData<List<T>>> {
        throw RuntimeException("Não implementado")
    }
    fun findById(id: ID): ResponseEntity<ResponseData<T>> {
        throw RuntimeException("Não implementado")
    }
    fun create(obj: T): ResponseEntity<ResponseData<T>> {
        throw RuntimeException("Não implementado")
    }
    fun update(obj: T): ResponseEntity<ResponseData<T>> {
        throw RuntimeException("Não implementado")
    }
}