package br.com.renovar.apirenovar.app.dataprovider.city.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.CacheConcurrencyStrategy
import javax.persistence.*

@Entity
@Table(name = "state")
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
class StateModel(
    @Id var id: Long = 0,
    var name: String = "",
    var uf: String = "",
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "state")
    @JsonBackReference
    val cities: MutableList<CityModel> = mutableListOf()
): BaseModel