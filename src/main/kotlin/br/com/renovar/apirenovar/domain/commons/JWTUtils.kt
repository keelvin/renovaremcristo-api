package br.com.renovar.apirenovar.domain.commons

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

class JWTUtils private constructor() {

    companion object {
        private const val SECRET_KEY = "01ddce78-7b42-474f-b9fa-cdf1f2bf0174"

        fun newToken(pgId: Long): String {
            val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY)
            val signingKey = SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.jcaName)

            return Jwts.builder()
                .claim("pg_id", pgId)
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact()
        }

        fun isValidToken(token: String) = try {
            val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY)
            val signingKey = SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.jcaName)

            val claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token)

            val pgIdClaim = claims.body["pg_id"]

            pgIdClaim != null && pgIdClaim.toString().toLong() > 0
        } catch (e: JwtException) {
            false
        } catch (e: Exception) {
            false
        }
    }
}