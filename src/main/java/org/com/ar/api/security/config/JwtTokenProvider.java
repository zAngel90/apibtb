package org.com.ar.api.security.config;

import java.util.Date;

import org.com.ar.api.security.exception.TokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {

   
    @Value("${jwt.secret}")
    private String jwtSecret;
    
    
    @Value("${jwt.refreshExpiration}")
    private long refreshExpirationInMs;

    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;

    /**
     * Genera un token JWT a partir de un objeto Authentication.
     *
     * @param authentication el objeto de autenticación.
     * @return el token JWT generado.
     */
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
    
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, decodedKey())
                .compact();
    }
    
    
    public String generateRefreshToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + refreshExpirationInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    
    /**
     * Extrae el nombre de usuario del token JWT.
     *
     * @param token el token JWT.
     * @return el nombre de usuario contenido en el token.
     */
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    /**
     * Valida un token JWT.
     *
     * @param token el token JWT a validar.
     * @return true si el token es válido, false en caso contrario.
     */
   public boolean validateToken(String token) {
    try {
        Jwts.parserBuilder()
            .setSigningKey(jwtSecret) // Clave de firma
            .build()
            .parseClaimsJws(token);
        return true;
    } catch (ExpiredJwtException ex) {
        log.error("El token ha expirado: {}", ex.getMessage());
        throw new TokenException("Token expirado");
    } catch (JwtException | IllegalArgumentException ex) {
        log.error("Error al validar el token: {}", ex.getMessage());
        throw new TokenException("Token inválido");
    }
}

        /**
     * Obtiene el array de bytes de la clave decodificada Base64.
     */
    private byte[] decodedKey() {
        // Decodifica la clave Base64
        return Decoders.BASE64.decode(jwtSecret);
        
    }

    
    public long getExpirationFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(decodedKey()) // Decodificar la clave si está en Base64
                .parseClaimsJws(token)
                .getBody();
    
        Date expiration = claims.getExpiration(); // Fecha de expiración
        return expiration.getTime() / 1000; // Convertir a segundos
    }
    
    
}
