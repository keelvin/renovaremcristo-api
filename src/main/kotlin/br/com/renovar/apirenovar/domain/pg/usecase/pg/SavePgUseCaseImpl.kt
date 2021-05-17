package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SavePgUseCaseImpl @Autowired constructor(private val pgDataProvider: PgDataProvider) : SavePgUseCase {
    override fun execute(pg: Pg): Pg {
        repeat(pg.members.size) {
            pg.members[it].pg = pg
        }

        pg.configuration.pg = pg

        try {
            return pgDataProvider.save(pg)
        } catch (e: Exception) {
            throw SaveException(e.message, e)
        }

    }
}