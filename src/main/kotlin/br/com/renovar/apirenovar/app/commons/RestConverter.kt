package br.com.renovar.apirenovar.app.commons

import br.com.renovar.apirenovar.domain.commons.BaseEntity

interface RestConverter<R: BaseRestModel, E: BaseEntity> {
    fun mapToRestModel(obj: E): R
    fun mapToEntity(obj: R): E
}