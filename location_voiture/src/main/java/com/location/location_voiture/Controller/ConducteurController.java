package com.location.location_voiture.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.location_voiture.Entity.Conducteur;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ConducteurRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Conducteur")
public class ConducteurController {
	@Autowired
    private ConducteurRepository conducteurRepository;
	  @GetMapping(value="/All")
		public List<Conducteur> GetAllConducteurs()
		{
			return conducteurRepository.findAll();
		}
	  @PostMapping(value="/create")
		public String CreateSociete(@RequestBody Conducteur conducteur)
		{
		  Conducteur C1=conducteurRepository.save(conducteur);
			return "Conducteur created" + " " + C1.getPrenomNomConducteur();
		}
	  @GetMapping("/findConducteurBy/{id}")
		 public Optional<Conducteur> getConducteur(@PathVariable long CodeConducteur)
		 {
			 
			 return conducteurRepository.findById(CodeConducteur);
		 }
	  @DeleteMapping(value="/delete/{id}")
		public String DeleteConducteur(@PathVariable long CodeConducteur)
		{
		  conducteurRepository.deleteById(CodeConducteur);
				return "Conducteur deleted" + " " + CodeConducteur;
		}

		@PutMapping(value="/Conducteur/{id}")
	  public Conducteur update(@RequestBody Conducteur conducteur, @PathVariable("CodeConducteur") long CodeConducteur) {
			Conducteur C = conducteurRepository.findById(CodeConducteur)
		                .orElseThrow(()->new NotFoundException("Conducteur avec "+CodeConducteur+" n'existe pas!"));
			C.setPrenomNomConducteur(conducteur.getPrenomNomConducteur());
			C.setDateNaissance(conducteur.getDateNaissance());
			C.setNumPermisConduite(conducteur.getNumPermisConduite());
			C.setDateLivraisonPermisConduite(conducteur.getDateLivraisonPermisConduite());
			C.setDateFinValidite(conducteur.getDateFinValidite());
			C.setAdresse(conducteur.getAdresse());
			C.setTel(conducteur.getTel());
			C.setNumCIN(conducteur.getNumCIN());
			C.setDateCin(conducteur.getDateCin());
			C.setMailConducteur(conducteur.getMailConducteur());
			C.setDateCreationConducteur(conducteur.getDateCreationConducteur());
			conducteurRepository.save(conducteur);
	        return conducteur;
	    }
}
