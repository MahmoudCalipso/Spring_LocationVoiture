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

import com.location.location_voiture.Entity.Maison;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.MaisonRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Maison")
public class MaisonController {
	
	@Autowired
	private MaisonRepository MaisonRepository;
	
	@GetMapping(value="/All")
	public List<Maison> GetAllMaison()
	{
		
		return MaisonRepository.findAll();
	}
    @PostMapping(value="/create")
	public String CreateMison(@RequestBody Maison maison)
	{
    	Maison M=MaisonRepository.save(maison);
		return "Maison créé avec succes" + " " +M.getNomMaison();
	}
    
    @GetMapping("/findMaisonBy/{id}")
	 public Optional<Maison> getMaison(@PathVariable long id)
	 {
		 
		 return MaisonRepository.findById(id);
	 }
	@DeleteMapping(value="/delete/{id}")
	public String DeleteMaison( @PathVariable long id)
	{
		MaisonRepository.deleteById(id);
			return "marque supprimé avec succes" + " " + id;
	}
	@PutMapping(value="/maison/{id}")
	public Maison update(@RequestBody Maison maison, @PathVariable("id") long id) {
		Maison M = MaisonRepository.findById(id)
	                .orElseThrow(()->new NotFoundException("Maison avec "+id+" n'existe pas!"));
	
		M.setNomMaison(maison.getNomMaison());
		MaisonRepository.save(maison);
        return maison;
	}

}
