package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import br.com.renovar.apirenovar.base.Validation
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
class Person(
    @Id
    @GenericGenerator(name = "PersonGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
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
    var city: City,

    var address: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id")
    var church: Church,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_type_id")
    var personType: PersonType,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    var district: CityDistrict,

    @Type(type = "org.hibernate.type.NumericBooleanType")
    var active: Boolean = true
) : BaseEntity()