package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Voiture;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Voiture")
public class VoitureController {

	@Autowired
    private VoitureRepository VoitureRepository;
    
    @GetMapping(value="/All")
	public List<Voiture> GetAllVoitures()
	{
		
		return VoitureRepository.findAll();
	}
    @PostMapping(value="/create")
	public String CreateVoiture(@RequestBody Voiture voiture)
	{
    	Voiture V1=VoitureRepository.save(voiture);
		return "student created" + " " + V1.getMatricule();
	}
	@GetMapping("/findVoitureBy/{id}")
	 public Optional<Voiture> getVoiture(@PathVariable long idVoiture)
	 {
		 
		 return VoitureRepository.findById(idVoiture);
	 }
	@DeleteMapping(value="/delete/{id}")
	public String DeleteVoiture(@PathVariable long idVoiture)
	{
		VoitureRepository.deleteById(idVoiture);
			return "student deleted" + " " + idVoiture;
	}

	@PutMapping(value="/voiture/{id}")
	public Voiture update(@RequestBody Voiture voiture, @PathVariable("idVoiture") long idVoiture) {
		Voiture V = VoitureRepository.findById(idVoiture)
	                .orElseThrow(()->new NotFoundException("Voiture avec "+idVoiture+" n'existe pas!"));
		V.setDatemisecirculation(voiture.getDatemisecirculation());
		V.setKilometrage(voiture.getKilometrage());
		V.setMatricule(voiture.getMatricule());
		V.setNumcartegrise(voiture.getNumcartegrise());
		V.setMaison(voiture.getMaison());
		V.setMarque(voiture.getMarque());
		V.setModel(voiture.getModel());
		VoitureRepository.save(voiture);
        return voiture;
    }

	
}
