package br.com.renovar.apirenovar.business

import br.com.renovar.apirenovar.base.BaseBusiness
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.base.Validation
import br.com.renovar.apirenovar.contracts.PersonBusinessContract
import br.com.renovar.apirenovar.entities.Person
import br.com.renovar.apirenovar.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PersonBusiness(@Autowired private val repository: PersonRepository) : BaseBusiness<Person, Long, PersonRepository>(repository), PersonBusinessContract {
    override fun findAllByActiveIsTrue(): List<Person> = this.repository.findAllByActiveIsTrue()

    override fun findAllByChurchIdAndActiveIsTrue(churchId: Long): List<Person> =
        this.repository.findAllByChurchIdAndActiveIsTrue(churchId)

    override fun findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId: Long, personTypeId: Long): List<Person> =
        this.repository.findAllByChurchIdAndActiveIsTrueAndPersonTypeId(churchId, personTypeId)

    override fun findAllByActiveIsTrueAndPersonTypeId(personTypeId: Long): List<Person> =
        this.repository.findAllByActiveIsTrueAndPersonTypeId(personTypeId)

    override fun findByEmail(email: String): Person? = this.repository.findByEmail(email)

    override fun findByEmailAndActiveIsTrue(email: String): Person? = this.repository.findByEmailAndActiveIsTrue(email)

    override fun validate(obj: Person): ResponseData<Boolean> {
        if (obj.id == 0L && this.findByEmailAndActiveIsTrue(obj.email) != null) {
            return ResponseData.failure("Já existe um usuário com esse email")
        }

        if (obj.name.isEmpty()) return ResponseData.failure("O nome é obrigatório")
        if (obj.address.isEmpty()) return ResponseData.failure("O endereço é obrigatório")
        if (obj.birthday.time == 0L) return ResponseData.failure("A data de nascimento é obrigatória")
        if (obj.email.isEmpty()) return ResponseData.failure("O email é obrigatório")
        if (obj.phone.isEmpty()) return ResponseData.failure("O telefone é obrigatório")

        return super.validate(obj)
    }

}
