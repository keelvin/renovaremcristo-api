package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PgMemberType
import org.springframework.stereotype.Repository

@Repository
interface PgMemberTypeRepository : BaseRepository<PgMemberType, Long>