package br.com.renovar.apirenovar.app.dataprovider.city.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "state")
class StateModel(
    @Id var id: Long = 0,
    var name: String = "",
    var uf: String = "",
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "state")
    @JsonBackReference
    val cities: MutableList<CityModel> = mutableListOf()
): BaseModel