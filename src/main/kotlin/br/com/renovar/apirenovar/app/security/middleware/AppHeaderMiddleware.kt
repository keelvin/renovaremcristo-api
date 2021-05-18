package br.com.renovar.apirenovar.app.security.middleware

import br.com.renovar.apirenovar.app.commons.AppCommons
import br.com.renovar.apirenovar.app.commons.ResponseData
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class AppHeaderMiddleware : Middleware {
    override fun validate(request: HttpServletRequest): ResponseData<Boolean> {
        val appKeyHeaderValue = request.getHeader("app_key")

        return if (appKeyHeaderValue == null || appKeyHeaderValue !=  AppCommons.APP_KEY) {
            ResponseData.failure("Aplicação não autorizada")
        } else {
            ResponseData.success(true)
        }
    }
}