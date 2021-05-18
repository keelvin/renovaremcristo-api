package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pg_type_def")
class PgTypeModel(
    @Id var id: Long = 0,
    var description: String = ""
): BaseModel