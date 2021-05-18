package br.com.renovar.apirenovar.domain.security.usecase

interface GenerateTokenUseCase {
    fun execute(pgId: Long): String
}