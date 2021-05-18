package br.com.renovar.apirenovar.app.dataprovider.pg.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberTypeModel
import org.springframework.stereotype.Repository

@Repository
interface PgMemberTypeRepository : BaseRepository<PgMemberTypeModel, Long>