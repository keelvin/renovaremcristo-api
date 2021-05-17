package br.com.renovar.apirenovar

import br.com.renovar.apirenovar.base.ResponseData
import br.com.renovar.apirenovar.exceptions.NotAuthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [NotAuthorizedException::class])
    fun handleNotAuthorized(ex: RuntimeException, request: WebRequest): ResponseEntity<ResponseData<Boolean>> {
        val message = ex.message ?: "Não autorizado o acesso"

        return ResponseEntity(ResponseData.failure(message), HttpStatus.UNAUTHORIZED)
    }
}