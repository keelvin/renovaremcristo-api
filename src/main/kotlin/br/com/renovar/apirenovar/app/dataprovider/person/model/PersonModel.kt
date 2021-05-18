package br.com.renovar.apirenovar.app.dataprovider.person.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.church.model.ChurchModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityDistrictModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
class PersonModel(
    @Id
    @GenericGenerator(name = "PersonGenerator", strategy = "br.com.renovar.apirenovar.app.commons.PostgreSequenceStrategy", parameters = [
        Parameter(value = "person_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonGenerator")
    var id: Long = 0,

    var name: String = "",

    var email: String = "",

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    @Temporal(value = TemporalType.DATE)
    var birthday: Date = Date(),

    var phone: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    var city: CityModel,

    var address: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id")
    var church: ChurchModel,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_type_id")
    var personType: PersonTypeModel,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    var district: CityDistrictModel?,

    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
): BaseModel