package br.com.renovar.apirenovar.app.dataprovider.pgreport.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import javax.persistence.*

@Entity
@Table(name = "pg_report_member_situation")
class PgReportMemberSituationModel(
    @Id
    @GenericGenerator(name = "PgReportMemberSituationGenerator", strategy = "br.com.renovar.apirenovar.app.commons.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_member_situation_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportMemberSituationGenerator")
    var id: Long = 0,
    var description: String = ""
): BaseModel