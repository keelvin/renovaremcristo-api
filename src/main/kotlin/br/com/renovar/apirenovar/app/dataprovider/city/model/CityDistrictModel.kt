package br.com.renovar.apirenovar.app.dataprovider.city.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "city_district")
class CityDistrictModel(
    @Id var id: Long = 0,
    var name: String = "",
    @Column(name = "city_id") var cityId: Long = 0
): BaseModel