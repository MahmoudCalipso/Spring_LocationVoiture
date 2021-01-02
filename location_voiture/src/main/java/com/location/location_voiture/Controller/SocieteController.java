package com.location.location_voiture.Controller;
import com.location.location_voiture.Entity.Societe;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Societe")
public class SocieteController {
	@Autowired
    private SocieteRepository SocieteRepository;
	  @GetMapping(value="/All")
		public List<Societe> GetAllSocietes()
		{
			
			return SocieteRepository.findAll();
		}
	  @PostMapping(value="/create")
		public String CreateSociete(@RequestBody Societe societe)
		{
		  Societe S1=SocieteRepository.save(societe);
			return "Societe created" + " " + S1.getNomSociete();
		}
	  @GetMapping("/findSocieteBy/{id}")
		 public Optional<Societe> getSociete(@PathVariable long NumSociete)
		 {
			 
			 return SocieteRepository.findById(NumSociete);
		 }
	  @DeleteMapping(value="/delete/{id}")
		public String DeleteSociete(@PathVariable long NumSociete)
		{
		  SocieteRepository.deleteById(NumSociete);
				return "Societe deleted" + " " + NumSociete;
		}

		@PutMapping(value="/societe/{id}")
	  public Societe update(@RequestBody Societe societe, @PathVariable("NumSociete") long NumSociete) {
			Societe S = SocieteRepository.findById(NumSociete)
		                .orElseThrow(()->new NotFoundException("Societe avec "+NumSociete+" n'existe pas!"));
			S.setNomSociete(societe.getNomSociete());
			S.setPersonnePhysique(societe.getPersonnePhysique());
			S.setAdresseSociete(societe.getAdresseSociete());
			S.setTelSociete(societe.getTelSociete());
			S.setMailSociete(societe.getMailSociete());
			S.setDateCreationSociete(societe.getDateCreationSociete());
			S.setPrenomNomRepresentantSociete(societe.getPrenomNomRepresentantSociete());
			S.setTelRepresentantSociete(societe.getTelRepresentantSociete());

			SocieteRepository.save(societe);
	        return societe;
	    }
}
