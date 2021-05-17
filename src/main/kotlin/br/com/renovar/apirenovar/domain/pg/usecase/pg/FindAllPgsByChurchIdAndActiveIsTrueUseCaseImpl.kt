package br.com.renovar.apirenovar.domain.pg.usecase.pg

import br.com.renovar.apirenovar.domain.pg.dataprovider.PgDataProvider
import br.com.renovar.apirenovar.domain.pg.entity.Pg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllPgsByChurchIdAndActiveIsTrueUseCaseImpl @Autowired constructor(
    private val pgDataProvider: PgDataProvider
): FindAllPgsByChurchIdAndActiveIsTrueUseCase {
    override fun execute(churchId: Long) = pgDataProvider.findAllByChurchIdAndActiveIsTrue(churchId)
}