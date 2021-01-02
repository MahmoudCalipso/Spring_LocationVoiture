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

import com.location.location_voiture.Entity.Model;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ModelRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/Model")
public class ModelController {
	
	@Autowired
    private ModelRepository ModelRepository;
    
	 @GetMapping(value="/All")
		public List<Model> GetAllModel()
		{
			
			return ModelRepository.findAll();
		}
	    @PostMapping(value="/create")
		public String CreateModel(@RequestBody Model model)
		{
	    	Model M=ModelRepository.save(model);
			return "model créé avec succes" + " " +M.getNomModel();
		}
	    
	    @GetMapping("/findModelBy/{id}")
		 public Optional<Model> getModel(@PathVariable long id)
		 {
			 
			 return ModelRepository.findById(id);
		 }
		@DeleteMapping(value="/delete/{id}")
		public String DeleteVoiture( @PathVariable long id)
		{
			ModelRepository.deleteById(id);
				return "model supprimé avec succes" + " " + id;
		}
		@PutMapping(value="/model/{id}")
		public Model update(@RequestBody Model model, @PathVariable("id") long id) {
			Model M = ModelRepository.findById(id)
		                .orElseThrow(()->new NotFoundException("Voiture avec "+id+" n'existe pas!"));
		
			M.setNomModel(model.getNomModel());
			ModelRepository.save(model);
	        return model;
		}
}
