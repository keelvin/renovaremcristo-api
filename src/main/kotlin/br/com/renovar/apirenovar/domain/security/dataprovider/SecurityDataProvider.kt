package br.com.renovar.apirenovar.domain.security.dataprovider

interface SecurityDataProvider {
    fun isValidToken(token: String, privateKey: String): Boolean
    fun newToken(pgId: Long, privateKey: String): String
}