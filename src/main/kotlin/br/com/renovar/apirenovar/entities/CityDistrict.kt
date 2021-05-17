package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "city_district")
class CityDistrict(
    @Id var id: Long = 0,
    var name: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    @JsonBackReference
    var city: City,
): BaseEntity()