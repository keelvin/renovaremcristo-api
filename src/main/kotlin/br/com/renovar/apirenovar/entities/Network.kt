package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "network")
class Network(
    @Id
    @GenericGenerator(name = "NetworkGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "network_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NetworkGenerator")
    var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leader_id")
    var leader: Person,
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
) : BaseEntity()