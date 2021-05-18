package br.com.renovar.apirenovar.app.security.middleware

import br.com.renovar.apirenovar.app.commons.ResponseData
import javax.servlet.http.HttpServletRequest

interface Middleware {
    fun validate(request: HttpServletRequest): ResponseData<Boolean>
}