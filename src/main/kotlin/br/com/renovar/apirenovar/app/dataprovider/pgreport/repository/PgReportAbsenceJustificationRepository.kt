package br.com.renovar.apirenovar.app.dataprovider.pgreport.repository

import br.com.renovar.apirenovar.app.commons.BaseRepository
import br.com.renovar.apirenovar.app.dataprovider.pgreport.model.PgReportAbsenceJustificationModel
import org.springframework.stereotype.Repository

@Repository
interface PgReportAbsenceJustificationRepository : BaseRepository<PgReportAbsenceJustificationModel, Long>