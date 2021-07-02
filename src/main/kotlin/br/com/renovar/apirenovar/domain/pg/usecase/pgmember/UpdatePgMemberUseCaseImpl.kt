package br.com.renovar.apirenovar.domain.pg.usecase.pgmember

import br.com.renovar.apirenovar.domain.exceptions.UpdatePgMemberException
import br.com.renovar.apirenovar.domain.pg.entity.PgMember
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class UpdatePgMemberUseCaseImpl constructor(
    private val findPgMemberByIdUseCase: FindPgMemberByIdUseCase,
    private val savePgMemberUseCase: SavePgMemberUseCase,
    private val validatePgMemberUseCase: ValidatePgMemberUseCase,
    private val findPgMemberByPhoneUseCase: FindPgMemberByPhoneUseCase,
    private val findPgMemberByEmailUseCase: FindPgMemberByEmailUseCase
) : UpdatePgMemberUseCase {

    @Throws(UpdatePgMemberException::class)
    override fun execute(obj: PgMember): PgMember {
        try {
            validatePgMemberUseCase.execute(obj)
        } catch (ex: Exception) {
            throw UpdatePgMemberException(ex.message, ex)
        }

        val actualObj = findPgMemberByIdUseCase.execute(obj.id) ?: throw UpdatePgMemberException("Não localizado membro com o ID informado")

        if (obj.person.email != actualObj.person.email && findPgMemberByEmailUseCase.execute(obj.person.email) != null) {
            throw UpdatePgMemberException("Já existe cadastro com o email informado")
        }

        if (obj.person.phone != actualObj.person.phone && findPgMemberByPhoneUseCase.execute(obj.person.phone) != null) {
            throw UpdatePgMemberException("Já existe cadastro com o telefone informado")
        }

        try {
            return savePgMemberUseCase.execute(obj)
        } catch (ex: Exception) {
            throw UpdatePgMemberException(ex.message, ex)
        }
    }
}