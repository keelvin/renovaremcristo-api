package br.com.renovar.apirenovar.app.dataprovider.church

import br.com.renovar.apirenovar.app.dataprovider.church.converters.ChurchEntityConverter
import br.com.renovar.apirenovar.app.dataprovider.church.repository.ChurchRepository
import br.com.renovar.apirenovar.domain.church.dataprovider.ChurchDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchProvider @Autowired constructor(
    private val churchRepository: ChurchRepository,
    private val churchEntityConverter: ChurchEntityConverter
) : ChurchDataProvider {

    override fun findAll() = churchRepository.findAll().map { churchEntityConverter.mapToEntity(it) }

    override fun findById(id: Long) = churchRepository.findById(id).orElse(null)?.let {
        return@let churchEntityConverter.mapToEntity(it)
    }

}