package br.com.renovar.apirenovar.app.dataprovider.security

import br.com.renovar.apirenovar.domain.security.dataprovider.SecurityDataProvider
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SecurityProvider : SecurityDataProvider {
    override fun isValidToken(token: String, privateKey: String) = try {
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(privateKey)
        val signingKey = SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.jcaName)

        val claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token)

        val pgIdClaim = claims.body["pg_id"]

        pgIdClaim != null && pgIdClaim.toString().toLong() > 0
    } catch (e: JwtException) {
        false
    } catch (e: Exception) {
        false
    }

    override fun newToken(pgId: Long, privateKey: String): String {
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(privateKey)
        val signingKey = SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.jcaName)

        return Jwts.builder()
            .claim("pg_id", pgId)
            .signWith(SignatureAlgorithm.HS512, signingKey)
            .compact()
    }

}