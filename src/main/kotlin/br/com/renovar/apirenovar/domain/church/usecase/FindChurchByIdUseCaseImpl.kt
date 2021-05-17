package br.com.renovar.apirenovar.domain.church.usecase

import br.com.renovar.apirenovar.domain.church.dataprovider.ChurchDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class FindChurchByIdUseCaseImpl @Autowired constructor(
    private val churchDataProvider: ChurchDataProvider
) : FindChurchByIdUseCase {
    override fun execute(id: Long) = churchDataProvider.findById(id)
}