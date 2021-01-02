package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.location_voiture.Entity.Maison;

public interface MaisonRepository extends JpaRepository<Maison, Long> {

}
