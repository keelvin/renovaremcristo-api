package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.Church
import org.springframework.stereotype.Repository

@Repository
interface ChurchRepository : BaseRepository<Church, Long>