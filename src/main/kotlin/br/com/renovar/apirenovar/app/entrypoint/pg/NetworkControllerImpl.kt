package br.com.renovar.apirenovar.app.entrypoint.pg

import br.com.renovar.apirenovar.app.entrypoint.pg.converters.NetworkRestConverter
import br.com.renovar.apirenovar.app.entrypoint.pg.models.NetworkRestModel
import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.configurations.AppCommons
import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pg.usecase.network.*
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/network")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NetworkControllerImpl constructor(
    private val networkRestConverter: NetworkRestConverter,
    private val findAllActiveNetworksUseCase: FindAllActiveNetworksUseCase,
    private val findAllNetworksByLeaderIdAndActiveUseCase: FindAllNetworksByLeaderIdAndActiveUseCase,
    private val findAllNetworksByLeaderIdUseCase: FindAllNetworksByLeaderIdUseCase,
    private val findAllNetworksUseCase: FindAllNetworksUseCase,
    private val saveNetworkUseCase: SaveNetworkUseCase
): NetworkController {

    @GetMapping(value = ["/actives/leader/{leaderId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByLeaderIdAndActiveIsTrue(@PathVariable("leaderId") leaderId: Long): ResponseEntity<ResponseData<List<NetworkRestModel>>> {
        val objs = findAllNetworksByLeaderIdAndActiveUseCase.execute(leaderId)

        return ResponseEntity(
            ResponseData.success(objs.map { networkRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/actives/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByActiveIsTrue(): ResponseEntity<ResponseData<List<NetworkRestModel>>> {
        val objs = findAllActiveNetworksUseCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { networkRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/leader/{leaderId}"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAllByLeaderId(@PathVariable("leaderId") leaderId: Long): ResponseEntity<ResponseData<List<NetworkRestModel>>> {
        val objs = findAllNetworksByLeaderIdUseCase.execute(leaderId)

        return ResponseEntity(
            ResponseData.success(objs.map { networkRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @GetMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8])
    override fun findAll(): ResponseEntity<ResponseData<List<NetworkRestModel>>> {
        val objs = findAllNetworksUseCase.execute()

        return ResponseEntity(
            ResponseData.success(objs.map { networkRestConverter.mapToRestModel(it) }),
            HttpStatus.OK
        )
    }

    @PostMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8], consumes = [AppCommons.APPLICATION_JSON_UTF8])
    override fun create(@RequestBody obj: NetworkRestModel): ResponseEntity<ResponseData<NetworkRestModel>> {
        return try {
            val savedObj = saveNetworkUseCase.execute(networkRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(networkRestConverter.mapToRestModel(savedObj)),
                HttpStatus.OK
            )
        } catch (e: SaveException) {
            e.printStackTrace()

            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }
    }

    @PutMapping(value = ["/"], produces = [AppCommons.APPLICATION_JSON_UTF8], consumes = [AppCommons.APPLICATION_JSON_UTF8])
    override fun update(@RequestBody obj: NetworkRestModel): ResponseEntity<ResponseData<NetworkRestModel>> {
        return try {
            val savedObj = saveNetworkUseCase.execute(networkRestConverter.mapToEntity(obj))

            ResponseEntity(
                ResponseData.success(networkRestConverter.mapToRestModel(savedObj)),
                HttpStatus.OK
            )
        } catch (e: SaveException) {
            e.printStackTrace()

            ResponseEntity(
                ResponseData.failure(e.message ?: ""),
                HttpStatus.BAD_REQUEST
            )
        }
    }


}