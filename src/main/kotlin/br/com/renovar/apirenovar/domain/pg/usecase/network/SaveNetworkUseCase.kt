package br.com.renovar.apirenovar.domain.pg.usecase.network

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.entity.Network
import kotlin.jvm.Throws

interface SaveNetworkUseCase {
    @Throws(exceptionClasses = [SaveException::class])
    fun execute(network: Network): Network
}