package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pg_report")
class PgReport(
    @Id
    @GenericGenerator(name = "PgReportGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportGenerator")
    var id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_id")
    var pg: Pg,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var date: Date = Date(),
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "report")
//    @JoinColumn(name = "report_id")
    @JsonManagedReference
    val data: MutableList<PgReportData> = mutableListOf(),
) : BaseEntity()