package org.com.ar.api.security.controller;

import org.com.ar.api.security.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.com.ar.api.security.dto.request.AuthRequest;
import org.com.ar.api.security.dto.response.AuthResponse;
import org.com.ar.api.security.exception.TokenException;


@Slf4j
@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoints related to user authentication")
public class AuthController {


    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    @Operation(
        summary = "Authenticate user and generate JWT token",
        description = "This endpoint allows authenticating a user using `username` and `password`. It also requires `client_id` and `client_secret` in the headers.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Credentials to authenticate the user",
            required = true,
            content = @Content(
                schema = @Schema(implementation = AuthRequest.class),
                examples = {
                    @ExampleObject(
                        name = "Login example",
                        summary = "Example credentials",
                        description = "Example data to authenticate a user.",
                        value = "{ \"username\": \"admin\", \"password\": \"password\" }"
                    )
                }
            )
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful authentication"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials"),
            @ApiResponse(responseCode = "500", description = "Server error")
        }
    )
    public ResponseEntity<?> authenticateUser(
        @Parameter(description = "Client ID", example = "my-client-id") 
        @RequestHeader(value = "client_id", required = true) String clientId,
        
        @Parameter(description = "Client secret", example = "my-client-secret") 
        @RequestHeader(value = "client_secret", required = true) String clientSecret,
        
        @RequestBody AuthRequest authRequest
    ) {
        log.info("Authenticating user: {}", authRequest.getUsername());
    
        // Validate client_id and client_secret
        if (!isValidClient(clientId, clientSecret)) {
            log.error("Invalid client_id or client_secret");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid client credentials.");
        }
    
        try {
    
            // Generate JWT token
            String token = jwtTokenProvider.generateToken(authRequest.getUsername());
            log.info("Token successfully generated for user: {}", authRequest.getUsername());
            String refreshToken = jwtTokenProvider.generateRefreshToken(authRequest.getUsername());
    
            // Create response with token and expiration details
            AuthResponse response = new AuthResponse(token, refreshToken, jwtTokenProvider.getExpirationFromToken(token));
            return ResponseEntity.ok(response);
    
        } catch (BadCredentialsException ex) {
            log.error("Authentication error: Incorrect credentials for user {}", authRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect credentials.");
        } catch (Exception ex) {
            log.error("Unexpected error during authentication: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected server error.");
        }
    }

    
    
    @PostMapping("/refresh-token")
@Operation(
    summary = "Renew JWT token using refresh token",
    description = "This endpoint allows generating a new JWT token using a valid refresh token.",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Refresh token",
        required = true,
        content = @Content(
            schema = @Schema(type = "string"),
            examples = @ExampleObject(value = "eyJhbGciOiJIUzI1NiJ9...")
        )
    ),
    responses = {
        @ApiResponse(responseCode = "200", description = "Token renewed successfully"),
        @ApiResponse(responseCode = "401", description = "Invalid or expired refresh token"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    }
)
public ResponseEntity<?> refreshToken(@RequestBody String refreshToken) {
    try {
        // Validate the refresh token
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token.");
        }

        // Extract username from refresh token
        String username = jwtTokenProvider.getUsernameFromJWT(refreshToken);
 
        // Generate new tokens
        String newAccessToken = jwtTokenProvider.generateToken(username);
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(username);

        AuthResponse response = new AuthResponse(
            newAccessToken,
            newRefreshToken,
            jwtTokenProvider.getExpirationFromToken(newAccessToken)
        );

        return ResponseEntity.ok(response);
    } catch (TokenException ex) {
        log.error("Error during refresh token processing: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    } catch (Exception ex) {
        log.error("Unexpected error during token refresh: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected server error.");
    }
}
    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String hashedPassword = encoder.encode(rawPassword);
        log.info("Hashed password: " + hashedPassword);
    }

    private boolean isValidClient(String clientId, String clientSecret) {
        // Example values, you might load this from a database or configuration file
        final String validClientId = "my-client-id";
        final String validClientSecret = "my-client-secret";
    
        return validClientId.equals(clientId) && validClientSecret.equals(clientSecret);
    }
}
