package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.ClienteSucursal;
import org.com.ar.api.btb.entities.ClienteSucursalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteSucursalRepository extends JpaRepository<ClienteSucursal, ClienteSucursalId> {
    List<ClienteSucursal> findByLegajo(Short legajo);
} 