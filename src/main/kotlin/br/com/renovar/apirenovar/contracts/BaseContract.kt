package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.base.BaseEntity
import br.com.renovar.apirenovar.base.ResponseData

interface BaseContract<T: BaseEntity, ID: Any> {
    fun save(obj: T): ResponseData<T>
    fun delete(obj: T): Boolean
    fun deleteById(id: ID): Boolean
    fun findById(id: ID): T?
    fun findAll(): MutableList<T>
    fun validate(obj: T): ResponseData<Boolean>
}