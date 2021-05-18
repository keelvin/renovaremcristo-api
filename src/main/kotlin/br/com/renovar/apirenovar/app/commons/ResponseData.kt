package br.com.renovar.apirenovar.app.commons

class ResponseData<T: Any>(var successful: Boolean = false,
                           var message: String = "",
                           var code: Int = StatusCode.SUCCESS,
                           var data: T? = null) {

    companion object {
        fun <T : Any> failure(message: String, code: Int = StatusCode.GENERAL) = ResponseData<T>(
            message = message,
            code = code
        )

        fun <T : Any> success(data: T) = ResponseData(
            successful = true,
            data = data,
            code = StatusCode.SUCCESS
        )
    }

}