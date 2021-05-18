package br.com.renovar.apirenovar.domain.security.usecase

interface ValidateTokenUseCase {
    fun execute(token: String): Boolean
}