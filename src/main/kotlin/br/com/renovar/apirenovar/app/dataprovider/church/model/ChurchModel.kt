package br.com.renovar.apirenovar.app.dataprovider.church.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.app.dataprovider.city.model.CityModel
import javax.persistence.*

@Entity
@Table(name = "church")
class ChurchModel(
    @Id var id: Long = 0,
    var name: String = "",
    var cnpj: String = "",
    var email: String = "",
    var phone: String = "",
    @Column(name = "pastor_name") var pastorName: String = "",
    var address: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    var city: CityModel
): BaseModel