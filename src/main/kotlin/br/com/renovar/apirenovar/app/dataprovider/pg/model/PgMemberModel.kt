package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonModel
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pg_member")
class PgMemberModel(
    @Id
    @GenericGenerator(name = "PgMemberGenerator", strategy = "br.com.renovar.apirenovar.app.commons.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_member_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgMemberGenerator")
    var id: Long = 0,
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "pg_id", insertable = false, updatable = false, nullable = true)
    @JsonBackReference
    var pg: PgModel?,
    @Column(name = "pg_id") var pgId: Long,
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "person_id")
    var person: PersonModel,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_type_id")
    var type: PgMemberTypeModel,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "registered_at", updatable = false)
    var registeredAt: Date = Date(),
): BaseModel