package br.com.renovar.apirenovar.contracts

import br.com.renovar.apirenovar.entities.PgAuth

interface PgAuthContract : BaseContract<PgAuth, Long> {
    fun findByLoginAndPassword(login: String, password: String): PgAuth?
}