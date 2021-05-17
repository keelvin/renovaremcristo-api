package br.com.renovar.apirenovar.app.dataprovider.person.repository

import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonTypeModel
import br.com.renovar.apirenovar.app.commons.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonTypeRepository : BaseRepository<PersonTypeModel, Long>