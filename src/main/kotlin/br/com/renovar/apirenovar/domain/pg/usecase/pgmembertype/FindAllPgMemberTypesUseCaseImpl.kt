package br.com.renovar.apirenovar.domain.pg.usecase.pgmembertype

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgMemberTypeDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgMemberTypesUseCaseImpl @Autowired constructor(
    private val pgMemberTypeDataProvider: PgMemberTypeDataProvider
): FindAllPgMemberTypesUseCase {

    override fun execute() = pgMemberTypeDataProvider.findAll()

}