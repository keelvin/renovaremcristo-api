package br.com.renovar.apirenovar.app.dataprovider.person.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonTypeModel
import org.springframework.stereotype.Repository

@Repository
interface PersonTypeRepository : BaseRepository<PersonTypeModel, Long>