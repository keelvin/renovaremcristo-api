package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.*
import org.hibernate.annotations.Parameter
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "pg")
class Pg(
    @Id
    @GenericGenerator(name = "PgGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgGenerator")
    var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "network_id")
    var network: Network,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id")
    var church: Church,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    var city: City,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pg_type_id")
    var pgType: PgType,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "configuration_id", referencedColumnName = "id")
    @JsonManagedReference
    var configuration: PgConfiguration,
    @OneToMany(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY, targetEntity = PgMember::class)
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    val members: MutableList<PgMember> = mutableListOf(),
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
) : BaseEntity()