package br.com.renovar.apirenovar.domain.commons

import br.com.renovar.apirenovar.domain.exceptions.SaveException

interface DataProvider<T: BaseEntity> {
    fun findAll(): List<T> {
        throw RuntimeException("Não implementado")
    }
    fun findById(id: Long): T? {
        throw RuntimeException("Não implementado")
    }

    @Throws(exceptionClasses = [SaveException::class])
    fun save(obj: T): T {
        throw RuntimeException("Não implementado")
    }
    fun delete(obj: T) {
        throw RuntimeException("Não implementado")
    }
    fun deleteById(id: Long) {
        throw RuntimeException("Não implementado")
    }
}