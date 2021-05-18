package br.com.renovar.apirenovar.domain.pg.dataprovider

import br.com.renovar.apirenovar.domain.commons.DataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgAuth

interface PgAuthDataProvider : DataProvider<PgAuth> {
    fun findByLoginAndPassword(login: String, password: String): PgAuth?
}