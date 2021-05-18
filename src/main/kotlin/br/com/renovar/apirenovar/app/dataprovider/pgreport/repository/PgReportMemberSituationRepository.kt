package br.com.renovar.apirenovar.app.dataprovider.pgreport.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportMemberSituationModel
import org.springframework.stereotype.Repository

@Repository
interface PgReportMemberSituationRepository : BaseRepository<PgReportMemberSituationModel, Long>