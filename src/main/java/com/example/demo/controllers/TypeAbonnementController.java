
package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.TypeAbonnementRepository;
import com.example.demo.models.TypeAbonnement;

@RestController
@RequestMapping
public class TypeAbonnementController {
	private final TypeAbonnementRepository typeAbonnementRepository ;

	@Autowired
	public TypeAbonnementController(TypeAbonnementRepository TypeAbonnementRepository) {
		super();
		this.typeAbonnementRepository = TypeAbonnementRepository;
	}
	
	@PostMapping("/add-TypeAbonnement")
    public TypeAbonnement createTypeAbonnement( @RequestBody TypeAbonnement TypeAbonnement) {
        return typeAbonnementRepository.save(TypeAbonnement);
    }
	@DeleteMapping("/delete-TypeAbonnement/{id}")
    public String deleteTypeAbonnement(@PathVariable(value = "id") int id ) {
		
		typeAbonnementRepository.deleteById(id);
		return "TypeAbonnement suprimée!!";
	}
	
	@GetMapping("/TypeAbonnements")
    public List<TypeAbonnement> getAll() {
        return typeAbonnementRepository.findAll();
    }
	
    @GetMapping("find-TypeAbonnement/{id}")
    public Optional<TypeAbonnement> getBiblioById(@PathVariable(value = "id")  int TypeAbonnement_ID)
    {
		return typeAbonnementRepository.findById(TypeAbonnement_ID);
   
    }
    @PutMapping("update-TypeAbonnement/{id}")
    public ResponseEntity<TypeAbonnement> updateTypeAbonnement(@PathVariable(value = "id") int TypeAbonnement_Id,
            @RequestBody TypeAbonnement TypeAbonnement_Details){
      	Optional<TypeAbonnement> optionelEntity= typeAbonnementRepository.findById(TypeAbonnement_Id);
          TypeAbonnement ab = optionelEntity.get();
          ab.setNom_abonnement(TypeAbonnement_Details.getNom_abonnement());               
          ab.setTarif_abonnement(TypeAbonnement_Details.getTarif_abonnement());               
          ab.setDuree_abonnement(TypeAbonnement_Details.getDuree_abonnement());               
          
          final TypeAbonnement updatedTypeAbonnement = typeAbonnementRepository.save(ab);
          return ResponseEntity.ok(updatedTypeAbonnement);
      }
	

}