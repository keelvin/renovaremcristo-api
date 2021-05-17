package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.entity.Pg

interface FindAllPgsByChurchIdAndActiveIsTrueUseCase {
    fun execute(churchId: Long): List<Pg>
}