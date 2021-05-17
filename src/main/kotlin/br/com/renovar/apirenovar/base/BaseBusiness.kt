package br.com.renovar.apirenovar.base

import br.com.renovar.apirenovar.contracts.BaseContract
import br.com.renovar.apirenovar.responses.Responses

abstract class BaseBusiness<T: BaseEntity, ID: Any, R: BaseRepository<T, ID>>(private val repository: R) : BaseContract<T, ID> {

    override fun save(obj: T): ResponseData<T> {
        val validateResponse = this.validate(obj)

        if (!validateResponse.successful) return ResponseData.failure(validateResponse.message)

        return try {
            ResponseData.success(this.repository.save(obj))
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseData.failure(Responses.FAILURE)
        }
    }

    override fun delete(obj: T) = try {
        this.repository.delete(obj)

        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    override fun deleteById(id: ID) = try {
        this.repository.deleteById(id)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    override fun findById(id: ID): T? = this.repository.findById(id).orElse(null)
    override fun findAll(): MutableList<T> = this.repository.findAll()

    override fun validate(obj: T): ResponseData<Boolean> {
        return ResponseData.success(true)
    }

}