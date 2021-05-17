package br.com.renovar.apirenovar.app.dataprovider.person.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.base.BaseEntity
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person_type")
class PersonTypeModel(
    @Id var id: Long = 0,
    var description: String = ""
): BaseModel