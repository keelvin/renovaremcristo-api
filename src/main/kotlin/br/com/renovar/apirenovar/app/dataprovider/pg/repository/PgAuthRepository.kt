package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgAuthModel
import br.com.renovar.apirenovar.app.commons.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface PgAuthRepository : BaseRepository<PgAuthModel, Long> {
    fun findByLoginAndPassword(login: String, password: String): PgAuthModel?
}