package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.church.model.ChurchModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityDistrictModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "pg")
class PgModel(
    @Id
    @GenericGenerator(name = "PgGenerator", strategy = "br.com.renovar.apirenovar.app.commons.PostgreSequenceStrategy", parameters = [
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
    @OneToMany(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY, targetEntity = PgMemberModel::class)
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    val members: MutableList<PgMemberModel> = mutableListOf(),
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true,
    @Column(name = "day_of_week")
    var dayOfWeek: Int = 1,
    @Column
    var address: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    var district: CityDistrictModel? = null

    ): BaseModel