package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.person.model.PersonModel
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "network")
class NetworkModel(
    @Id
    @GenericGenerator(name = "NetworkGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "network_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NetworkGenerator")
    var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leader_id")
    var leader: PersonModel,
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
): BaseModel