package br.com.renovar.apirenovar.domain.church.usecase

import br.com.renovar.apirenovar.domain.church.dataprovider.ChurchDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindAllChurchesUseCaseImpl @Autowired constructor(
    private val churchDataProvider: ChurchDataProvider
) : FindAllChurchesUseCase {

    override fun execute() = churchDataProvider.findAll()

}