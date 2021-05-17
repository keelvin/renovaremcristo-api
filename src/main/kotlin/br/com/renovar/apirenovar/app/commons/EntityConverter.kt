package br.com.renovar.apirenovar.app.commons

import br.com.renovar.apirenovar.domain.commons.BaseEntity

interface EntityConverter<M: BaseModel, E: BaseEntity> {
    fun mapToModel(obj: E): M
    fun mapToEntity(obj: M): E
}