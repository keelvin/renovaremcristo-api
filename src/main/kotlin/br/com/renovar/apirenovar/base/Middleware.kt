package br.com.renovar.apirenovar.base

import javax.servlet.http.HttpServletRequest

interface Middleware {
    fun validate(request: HttpServletRequest): ResponseData<Boolean>
}