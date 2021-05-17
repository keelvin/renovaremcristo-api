package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pg_auth")
class PgAuth(
    @Id var id: Long = 0,
    var login: String = "",
    var password: String = "",
    @Column(name = "pg_id") var pgId: Long = 0
) : BaseEntity()