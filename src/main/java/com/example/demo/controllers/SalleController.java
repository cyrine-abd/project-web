
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

import com.example.demo.Dao.SalleRepository;
import com.example.demo.models.Salle;

@RestController
@RequestMapping
public class SalleController {
	private final SalleRepository salleRepository ;

	@Autowired
	public SalleController(SalleRepository salleRepository) {
		super();
		this.salleRepository = salleRepository;
	}
	
	@PostMapping("/add-salle")
    public Salle createSalle( @RequestBody Salle salle) {
        return salleRepository.save(salle);
    }
	@DeleteMapping("/delete-salle/{id}")
    public String deleteSalle(@PathVariable(value = "id") int id ) {
		
		salleRepository.deleteById(id);
		return "Salle suprimée!!";
	}
	
	@GetMapping("/salles")
    public List<Salle> getAll() {
        return salleRepository.findAll();
    }
	
    @GetMapping("find-salle/{id}")
    public Optional<Salle> getBiblioById(@PathVariable(value = "id")  int salle_ID)
    {
		return salleRepository.findById(salle_ID);
   
    }
    @PutMapping("update-salle/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable(value = "id") int salle_Id,
            @RequestBody Salle salle_Details){
      	Optional<Salle> optionelEntity= salleRepository.findById(salle_Id);

          Salle salle = optionelEntity.get();

          salle.setNom_salle(salle_Details.getNom_salle());
          salle.setAdresse_salle(salle_Details.getAdresse_salle());
          salle.setTel_salle(salle_Details.getTel_salle());
          
          salle.setVille_salle(salle_Details.getVille_salle());
          
          final Salle updatedsalle = salleRepository.save(salle);
          return ResponseEntity.ok(updatedsalle);
      }
	

}