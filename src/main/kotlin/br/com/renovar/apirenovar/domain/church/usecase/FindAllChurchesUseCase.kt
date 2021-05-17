package br.com.renovar.apirenovar.domain.church.usecase

import br.com.renovar.apirenovar.domain.church.entity.Church

interface FindAllChurchesUseCase {
    fun execute(): List<Church>
}