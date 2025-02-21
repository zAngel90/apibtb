package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.CabeProd;
import org.com.ar.api.btb.entities.CabeProdId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeProdRepository extends JpaRepository<CabeProd, CabeProdId> {
} 