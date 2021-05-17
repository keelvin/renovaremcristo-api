package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pg_member")
class PgMember(
    @Id
    @GenericGenerator(name = "PgMemberGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_member_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgMemberGenerator")
    var id: Long = 0,
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "pg_id", insertable = false, updatable = false, nullable = true)
    @JsonBackReference
    var pg: Pg?,
    @Column(name = "pg_id") var pgId: Long,
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE, CascadeType.ALL])
    @JoinColumn(name = "person_id")
    var person: Person,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_type_id")
    var type: PgMemberType,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "registered_at", updatable = false)
    var registeredAt: Date = Date(),
) : BaseEntity()