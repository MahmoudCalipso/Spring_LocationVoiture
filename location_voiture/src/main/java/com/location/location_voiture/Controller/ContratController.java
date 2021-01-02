package com.location.location_voiture.Controller;
import com.location.location_voiture.Entity.Contrat;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Contrat")
public class ContratController {
	@Autowired
    private ContratRepository contratRepository;
	  @GetMapping(value="/All")
		public List<Contrat> GetAllContrats()
		{
			
			return contratRepository.findAll();
		}
	  @PostMapping(value="/create")
		public String CreateContrat(@RequestBody Contrat contrat)
		{
		  Contrat C1=contratRepository.save(contrat);
			return "Contrat created" + " " + C1.getNumContrat();
		}
	  @GetMapping("/findContratBy/{id}")
		 public Optional<Contrat> getContrat(@PathVariable long NumContrat)
		 {
			 
			 return contratRepository.findById(NumContrat);
		 }
	  @DeleteMapping(value="/delete/{id}")
		public String DeleteContrat(@PathVariable long NumContrat)
		{
		  contratRepository.deleteById(NumContrat);
				return "Contrat deleted" + " " + NumContrat;
		}

		@PutMapping(value="/Contrat/{id}")
	  public Contrat update(@RequestBody Contrat contrat, @PathVariable("NumContrat") long NumContrat) {
			Contrat C = contratRepository.findById(NumContrat)
		                .orElseThrow(()->new NotFoundException("Conducteur avec "+NumContrat+" n'existe pas!"));
			C.setDateContrat(contrat.getDateContrat());
			C.setSociete(contrat.getSociete());
			C.setConducteurs(contrat.getConducteurs());
			C.setVoitures(contrat.getVoitures());
			C.setDateDebutLocation(contrat.getDateDebutLocation());
			C.setDateFinLocation(contrat.getDateFinLocation());
			C.setPrixUnitaireJour(contrat.getPrixUnitaireJour());
			C.setPrixTotal(contrat.getPrixTotal());
			C.setMontantAvance(contrat.getMontantAvance());
			C.setDateCreationContrat(contrat.getDateCreationContrat());
			contratRepository.save(contrat);
	        return contrat;
	    }
}
