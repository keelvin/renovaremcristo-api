package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PgAuth
import org.springframework.stereotype.Repository

@Repository
interface PgAuthRepository : BaseRepository<PgAuth, Long> {
    fun findByLoginAndPassword(login: String, password: String): PgAuth?
}