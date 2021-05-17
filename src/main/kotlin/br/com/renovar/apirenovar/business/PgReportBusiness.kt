package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.contracts.PgReportContract
import br.com.renovar.apirenovar.entities.PgReport
import br.com.renovar.apirenovar.repositories.PgReportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PgReportBusiness(@Autowired private val repository: PgReportRepository):
    BaseBusiness<PgReport, Long, PgReportRepository>(repository), PgReportContract {

    override fun findAllByPgId(pgId: Long) = this.repository.findAllByPgId(pgId)

    override fun findAllByDateBetween(initialDate: Date, finalDate: Date) =
        this.repository.findAllByDateBetween(initialDate, finalDate)

    override fun findAllByPgIdAndDateBetween(pgId: Long, initialDate: Date, finalDate: Date) =
        this.repository.findAllByPgIdAndDateBetween(pgId, initialDate, finalDate)

    override fun findAllByPgIdOrderByDateDesc(pgId: Long) = this.repository.findAllByPgIdOrderByDateDesc(pgId)

    override fun validate(obj: PgReport): ResponseData<Boolean> {
        repeat(obj.data.size) {
            obj.data[it].report = obj
        }

        return ResponseData.success(true)
    }
}