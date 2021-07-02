package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.CreatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CreatePgMemberUseCaseImpl constructor(
    private val savePgMemberUseCase: SavePgMemberUseCase
) : CreatePgMemberUseCase {

    @Throws(CreatePgMemberException::class)
    override fun execute(obj: PgMember): PgMember {
        try {
            return savePgMemberUseCase.execute(obj)
        } catch (ex: Exception) {
            throw CreatePgMemberException(ex.message, ex)
        }

    }
}