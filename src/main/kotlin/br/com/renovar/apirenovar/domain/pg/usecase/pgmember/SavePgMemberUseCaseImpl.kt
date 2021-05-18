package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SavePgMemberUseCaseImpl constructor(
    private val pgMemberDataProvider: PgMemberDataProvider
): SavePgMemberUseCase {
    @Throws(exceptionClasses = [SaveException::class])
    override fun execute(obj: PgMember): PgMember {
        try {
            return pgMemberDataProvider.save(obj)
        } catch(e: Exception) {
            throw SaveException(e.message, e)
        }
    }
}