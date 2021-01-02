package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.location_voiture.Entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	
}
