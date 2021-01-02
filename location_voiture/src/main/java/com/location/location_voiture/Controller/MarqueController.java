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

import com.location.location_voiture.Entity.Marque;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.MarqueRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Marque")
public class MarqueController {
	
	@Autowired
	private MarqueRepository MarqueRepository;
	
	@GetMapping(value="/All")
	public List<Marque> GetAllMarque()
	{
		
		return MarqueRepository.findAll();
	}
    @PostMapping(value="/create")
	public String CreateMarque(@RequestBody Marque marque)
	{
    	Marque M=MarqueRepository.save(marque);
		return "La marque créé avec succes" + " " +M.getNomMarque();
	}
    
    @GetMapping("/findMarqueBy/{id}")
	 public Optional<Marque> getMarque(@PathVariable long id)
	 {
		 
		 return MarqueRepository.findById(id);
	 }
	@DeleteMapping(value="/delete/{id}")
	public String DeleteMarque( @PathVariable long id)
	{
		MarqueRepository.deleteById(id);
			return "marque supprimé avec succes" + " " + id;
	}
	@PutMapping(value="/marque/{id}")
	public Marque update(@RequestBody Marque marque, @PathVariable("id") long id) {
		Marque M = MarqueRepository.findById(id)
	                .orElseThrow(()->new NotFoundException("Marque avec "+id+" n'existe pas!"));
	
		M.setNomMarque(marque.getNomMarque());
		MarqueRepository.save(marque);
        return marque;
	}

}
