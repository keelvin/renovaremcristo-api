package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "pg_report_absence_justification")
class PgReportAbsenceJustification(
    @Id
    @GenericGenerator(name = "PgReportMemberSituationGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_member_situation_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportMemberSituationGenerator")
    var id: Long = 0,
    var description: String = "",
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "require_justification")
    var requireJustification: Boolean = false
) : BaseEntity()