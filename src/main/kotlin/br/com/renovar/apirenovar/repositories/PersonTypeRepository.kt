package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PersonType
import org.springframework.stereotype.Repository

@Repository
interface PersonTypeRepository : BaseRepository<PersonType, Long>