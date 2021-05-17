package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pg_member_type")
class PgMemberTypeModel(
    @Id var id: Long = 0,
    var description: String = ""
): BaseModel