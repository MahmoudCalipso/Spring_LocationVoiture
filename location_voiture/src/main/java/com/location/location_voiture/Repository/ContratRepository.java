package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.location_voiture.Entity.Contrat;
@Repository 
public interface ContratRepository  extends JpaRepository<Contrat, Long> {

}
