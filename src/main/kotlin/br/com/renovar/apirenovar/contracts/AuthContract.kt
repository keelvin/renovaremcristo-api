package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.dtos.AuthResponseDto

interface AuthContract {
    fun authenticate(login: String, password: String): ResponseData<AuthResponseDto>
}