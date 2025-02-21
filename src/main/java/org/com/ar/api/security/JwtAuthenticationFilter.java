package org.com.ar.api.security;

import java.io.IOException;
import java.util.List;

import org.com.ar.api.security.config.JwtTokenProvider;
import org.com.ar.api.security.exception.TokenException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter implements Filter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    // Lista de rutas excluidas de la validación
    private static final List<String> EXCLUDED_ROUTES = List.of("/auth", "/auth/login", "/auth/register");

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            String requestURI = httpRequest.getRequestURI();

            // Validar si la ruta está excluida
            if (isExcludedRoute(requestURI)) {
                chain.doFilter(request, response);
                return;
            }

            String token = getJwtFromRequest(httpRequest);

            if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromJWT(token);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                var authentication = new JwtAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            chain.doFilter(request, response);
        } catch (TokenException ex) {
            // Manejo explícito de TokenException
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                String.format("{\"error\": \"Unauthorized\", \"message\": \"%s\", \"status\": 401}", ex.getMessage()));
        } catch (Exception ex) {
            // Manejo general de excepciones
            httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                String.format("{\"error\": \"Internal Server Error\", \"message\": \"%s\", \"status\": 500}",
                        ex.getMessage()));
        }
    }

    private boolean isExcludedRoute(String requestURI) {
        return EXCLUDED_ROUTES.stream().anyMatch(requestURI::startsWith);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
