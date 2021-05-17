package br.com.renovar.apirenovar.app.dataprovider.church.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.church.model.ChurchModel
import org.springframework.stereotype.Repository

@Repository
interface ChurchRepository : BaseRepository<ChurchModel, Long>