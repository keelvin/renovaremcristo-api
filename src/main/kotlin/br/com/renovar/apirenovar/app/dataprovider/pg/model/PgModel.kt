package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.church.model.ChurchModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.*
import org.hibernate.annotations.Parameter
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "pg")
class PgModel(
    @Id
    @GenericGenerator(name = "PgGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgGenerator")
    var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "network_id")
    var network: NetworkModel,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id")
    var church: ChurchModel,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    var city: CityModel,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pg_type_id")
    var pgType: PgTypeModel,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "configuration_id", referencedColumnName = "id")
    @JsonManagedReference
    var configuration: PgConfigurationModel,
    @OneToMany(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY, targetEntity = PgMemberModel::class)
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    val members: MutableList<PgMemberModel> = mutableListOf(),
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
): BaseModel