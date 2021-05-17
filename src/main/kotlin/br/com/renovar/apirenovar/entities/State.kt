package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "state")
class State(
    @Id var id: Long = 0,
    var name: String = "",
    var uf: String = "",
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "state")
    @JsonBackReference
    val cities: MutableList<City> = mutableListOf()
) : BaseEntity()