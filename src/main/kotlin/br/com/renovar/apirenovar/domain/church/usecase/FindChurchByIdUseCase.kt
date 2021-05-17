package br.com.renovar.apirenovar.domain.church.usecase

import br.com.renovar.apirenovar.domain.church.entity.Church

interface FindChurchByIdUseCase {
    fun execute(id: Long): Church?
}