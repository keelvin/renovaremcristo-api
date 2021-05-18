package br.com.renovar.apirenovar.app.dataprovider.city.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "city")
class CityModel(
    @Id var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    @JsonManagedReference
    var state: StateModel,
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    val districts: MutableList<CityDistrictModel> = mutableListOf()
): BaseModel