package br.com.renovar.apirenovar.app.commons

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.Configurable
import org.hibernate.id.IdentifierGenerator
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type
import java.io.Serializable
import java.util.*

@Suppress("unused")
class PostgreSequenceStrategy : IdentifierGenerator, Configurable {

    private lateinit var sequence: String

    override fun generate(p0: SharedSessionContractImplementor?, p1: Any?): Serializable {
        val connection = p0?.connection() ?: return 0

        val ps = connection.prepareStatement("SELECT NEXTVAL('"+ this.sequence +"') AS ID")

        val rs = ps.executeQuery()

        try {
            if (rs.next()) {
                return rs.getLong("ID")
            }

            return 0
        } finally {
            if (!ps.isClosed) ps.close()
        }
    }

    override fun configure(p0: Type?, p1: Properties?, p2: ServiceRegistry?) {
        this.sequence = p1?.getProperty("sequence") ?: ""
    }

}