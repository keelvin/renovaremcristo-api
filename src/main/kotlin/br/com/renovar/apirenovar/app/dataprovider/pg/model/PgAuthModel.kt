package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pg_auth")
class PgAuthModel(
    @Id var id: Long = 0,
    var login: String = "",
    var password: String = "",
    @Column(name = "pg_id") var pgId: Long = 0
): BaseModel