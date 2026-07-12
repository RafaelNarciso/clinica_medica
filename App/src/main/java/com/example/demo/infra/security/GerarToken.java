package com.example.demo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.domain.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class GerarToken {


    @Value("${api.security.token.secret}")
    private String secret;

    public String getToken(Usuario usario) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API medicina_api")
                    .withSubject(usario.getLogin())
                    .withClaim("id", usario.getId().toString())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String getSubjet(String tokenJWT) {

        try {
            var algoritimo = Algorithm.HMAC256(secret);

            return  JWT.require(algoritimo)
                    .withIssuer("API medicina_api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Erro ao verificar token JWT", exception);
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(java.time.ZoneOffset.of("-03:00"));
    }
}
