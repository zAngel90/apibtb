package org.com.ar.api.security;


import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private Object credentials;

    /**
     * Constructor para autenticación previa a la validación del token.
     * @param credentials El token JWT.
     */
    public JwtAuthenticationToken(Object credentials) {
        super(null);
        this.principal = null;
        this.credentials = credentials;
        setAuthenticated(false); // Marcar como no autenticado
    }

    /**
     * Constructor para autenticación después de la validación del token.
     * @param principal Los detalles del usuario.
     * @param credentials El token JWT.
     * @param authorities Los roles y permisos del usuario.
     */
    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true); // Marcar como autenticado
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null; // Borrar las credenciales para mayor seguridad
    }
}
