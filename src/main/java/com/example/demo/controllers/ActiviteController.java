
package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.ActiviteRepository;
import com.example.demo.Dao.TypeActiviteRepository;
import com.example.demo.models.Activite;
import com.example.demo.models.Activite;
import com.example.demo.models.Salle;
import com.example.demo.models.TypeActivite;

@RestController
@RequestMapping("activite")
public class ActiviteController {
	
	private final ActiviteRepository activiteRepository ;
	private final TypeActiviteRepository typeActiviteRepository ;
	
	
	public ActiviteController(ActiviteRepository activiteRepository) {
		this.typeActiviteRepository = null;
		this.activiteRepository = activiteRepository;
	}



	@DeleteMapping("/{id}")
    public String deleteActivite(@PathVariable(value = "id") int id ) {
		
		activiteRepository.deleteById(id);
		return "Activite suprimer!!";
	}
	@GetMapping
    public List<Activite> getAll() {
        return activiteRepository.findAll();
    }
	
    @GetMapping("/{id}")
    public Optional<Activite> getactiviteById(@PathVariable(value = "id")  int activite_ID)
    {
		return activiteRepository.findById(activite_ID);
   
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Activite> updateActivite(@PathVariable(value = "id") int activite_Id,
            @RequestBody Activite activite_Details){
      	Optional<Activite> optionelEntity= activiteRepository.findById(activite_Id);
      	Activite activite = optionelEntity.get();
      	activite.setDescription_activite(activite_Details.getDescription_activite());
        final Activite updatedActivite = activiteRepository.save(activite);
        return ResponseEntity.ok(updatedActivite);
        }
    
    @PostMapping()
    public Activite createActivite( @RequestBody Activite activite) {
		Optional<TypeActivite> optionalTypeActivite = typeActiviteRepository.findById(activite.getT_acivite().getId_typeActivite());
		activite.setT_acivite(optionalTypeActivite.get());
		return activiteRepository.save(activite);
    }

}