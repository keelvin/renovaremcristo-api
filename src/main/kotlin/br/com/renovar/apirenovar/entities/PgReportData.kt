package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import javax.persistence.*

@Entity
@Table(name = "pg_report_data")
class PgReportData(
    @Id
    @GenericGenerator(name = "PgReportDataGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_data_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportDataGenerator")
    var id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    var report: PgReport?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: PgMember,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situation_id")
    var situation: PgReportMemberSituation,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "absence_justification_Id")
    var absenceJustification: PgReportAbsenceJustification?,
    var justification: String? = ""
) : BaseEntity()