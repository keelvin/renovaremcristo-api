package br.com.renovar.apirenovar.entities

import br.com.renovar.apirenovar.base.BaseEntity
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pg_member_type")
class PgMemberType(
    @Id var id: Long = 0,
    var description: String = ""
) : BaseEntity()