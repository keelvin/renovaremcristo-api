package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.ValidatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ValidatePgMemberUseCaseImpl: ValidatePgMemberUseCase {
    @Throws(ValidatePgMemberException::class)
    override fun execute(obj: PgMember) {
        if (obj.person.email.isEmpty() && obj.person.phone.isEmpty()) {
            throw ValidatePgMemberException("Necessário informar o telefone ou o email")
        }
    }
}