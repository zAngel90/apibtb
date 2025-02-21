package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.Cliente;
import org.com.ar.api.btb.entities.ClienteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {
    
    List<Cliente> findByDocumentoTipoAndDocumentoNumero(Short documentoTipo, String documentoNumero);
    
    Optional<Cliente> findByCliproAndCodigo(String clipro, Integer codigo);
    
} 