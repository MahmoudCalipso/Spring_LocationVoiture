package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.location_voiture.Entity.Societe;
@Repository 
public interface SocieteRepository extends JpaRepository<Societe, Long> {

}
