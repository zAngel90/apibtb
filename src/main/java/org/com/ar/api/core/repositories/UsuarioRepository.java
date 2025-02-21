package org.com.ar.api.core.repositories;

import java.util.Optional;

import org.com.ar.api.core.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

