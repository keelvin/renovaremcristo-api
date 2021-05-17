package br.com.renovar.apirenovar.repositories

import br.com.renovar.apirenovar.base.BaseRepository
import br.com.renovar.apirenovar.entities.PgReportMemberSituation
import org.springframework.stereotype.Repository

@Repository
interface PgReportMemberSituationRepository : BaseRepository<PgReportMemberSituation, Long>