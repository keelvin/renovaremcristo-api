package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByChurchIdUseCase {
    fun execute(churchId: Long): List<Pg>
}