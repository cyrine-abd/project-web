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

import com.example.demo.Dao.MembreRepository;
import com.example.demo.Dao.SalleRepository;
import com.example.demo.models.Membre;
import com.example.demo.models.Salle;




@RestController
@RequestMapping
public class MembreController {
private final MembreRepository membreRepository;
private final SalleRepository salleRepository ;

	
	@Autowired
	public MembreController(MembreRepository MemRep)
	{this.membreRepository=MemRep;
	this.salleRepository = null;}
	
	@PostMapping("/add-membre")
    public Membre createmembre( @RequestBody Membre membre) {
		Optional<Salle> optionalSalle = salleRepository.findById(membre.salle_membre.getId_salle());
		membre.setSalle_membre(optionalSalle.get());
		return membreRepository.save(membre);
    }
	@DeleteMapping("/delete-membre/{id}")
    public String deletemembre(@PathVariable(value = "id") int id ) {
		
		membreRepository.deleteById(id);
		return "membre suprimée!!";
	}
	
	@GetMapping("/membres")
    public List<Membre> getAll() {
        return membreRepository.findAll();
    }
	
    @GetMapping("find-membre/{id}")
    public Optional<Membre> getBiblioById(@PathVariable(value = "id")  int membre_ID)
    {
		return membreRepository.findById(membre_ID);
   
    }
    @PutMapping("update-membre/{id}")
    public ResponseEntity<Membre> updatemembre(@PathVariable(value = "id") int membre_Id,
            @RequestBody Membre membre_Details){
      	Optional<Membre> optionelEntity= membreRepository.findById(membre_Id);

      	  Membre membre = optionelEntity.get();

          membre.setNom_membre(membre_Details.getNom_membre());
          membre.setPrenom_membre(membre_Details.getPrenom_membre());
          membre.setTel_membre(membre_Details.getTel_membre());
          membre.setAdresse_membre(membre_Details.getAdresse_membre());

          
          final Membre updatedmembre = membreRepository.save(membre);
          return ResponseEntity.ok(updatedmembre);
      }
	

}
