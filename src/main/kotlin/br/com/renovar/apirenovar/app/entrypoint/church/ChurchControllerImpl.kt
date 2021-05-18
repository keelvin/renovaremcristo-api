package br.com.renovar.apirenovar.app.entrypoint.church

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import br.com.renovar.apirenovar.app.entrypoint.church.converters.ChurchRestConverter
import br.com.renovar.apirenovar.app.entrypoint.church.models.ChurchRestModel
import br.com.renovar.apirenovar.domain.church.usecase.FindAllChurchesUseCase
import br.com.renovar.apirenovar.domain.church.usecase.FindChurchByIdUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/church")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ChurchControllerImpl @Autowired constructor(
    private val findAllChurchesUseCase: FindAllChurchesUseCase,
    private val findChurchByIdUseCase: FindChurchByIdUseCase,
    private val churchRestConverter: ChurchRestConverter
) : ChurchController {

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<ChurchRestModel>>> {
        val objs = findAllChurchesUseCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { churchRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/{id}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findById(@PathVariable("id") id: Long): ResponseEntity<ResponseData<ChurchRestModel>> {
        val obj = findChurchByIdUseCase.execute(id) ?: return ResponseEntity(
            ResponseData.failure("Não localizado registro com o valor informado"),
            HttpStatus.BAD_REQUEST
        )

        return ResponseEntity(
            ResponseData.success(churchRestConverter.mapToRestModel(obj)),
            HttpStatus.OK
        )
    }
}