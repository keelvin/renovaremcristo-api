package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "church")
class Church(
    @Id var id: Long = 0,
    var name: String = "",
    var cnpj: String = "",
    var email: String = "",
    var phone: String = "",
    @Column(name = "pastor_name") var pastorName: String = "",
    var address: String = "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    var city: City
) : BaseEntity()