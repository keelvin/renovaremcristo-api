package br.com.renovar.apirenovar.app.dataprovider.pgreport.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgModel
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pg_report")
class PgReportModel(
    @Id
    @GenericGenerator(name = "PgReportGenerator", strategy = "br.com.renovar.apirenovar.app.commons.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportGenerator")
    var id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_id")
    var pg: PgModel,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var date: Date = Date(),
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "report_id", nullable = false)
    val data: MutableList<PgReportDataModel> = mutableListOf(),
): BaseModel