package br.com.renovar.apirenovar.app.dataprovider.pgreport.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.pg.model.PgMemberModel
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import javax.persistence.*

@Entity
@Table(name = "pg_report_data")
class PgReportDataModel(
    @Id
    @GenericGenerator(name = "PgReportDataGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_report_data_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgReportDataGenerator")
    var id: Long = 0,
    //@Column(name = "report_id") var reportId: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: PgMemberModel,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situation_id")
    var situation: PgReportMemberSituationModel,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "absence_justification_Id")
    var absenceJustification: PgReportAbsenceJustificationModel?,
    var justification: String? = ""
): BaseModel