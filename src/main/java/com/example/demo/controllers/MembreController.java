package com.example.demo.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.MembreRepository;
import com.example.demo.modal.Bibliotheque;
import com.example.demo.models.Membre;




@RestController
@RequestMapping
public class MembreController {
private final MembreRepository MemRep;
	
	@Autowired
	public MembreController(MembreRepository MemRep)
	{this.MemRep=MemRep;}
	
	@PostMapping("/add-Membre")
    public ResponseEntity<Membre> addMembre(@RequestBody Membre membre){     
		Membre membre1=MemRep.save(membre);
        return ResponseEntity.ok(membre);
    }
	
	@GetMapping("/membre/{id}")
    public ResponseEntity<Membre> findMembre(@PathVariable("id") Integer id){
        Optional<Membre>  membre=MemRep.findById(id);       
        return ResponseEntity.ok(membre.get());
	}
	@PutMapping("/update-Membre/{id}")
    public ResponseEntity<Membre> updateMembre(@RequestBody Membre membre1,@PathVariable (value="id") int id) {
		Membre membre=MemRep.findById(id).get();
		membre.setAdresse_membre(membre1.getAdresse_membre());
		membre.setNom_membre(membre1.getNom_membre());
		membre.setPrenom_membre(membre1.getPrenom_membre());
		membre.setTel_membre(membre1.getTel_membre());
		membre.setListeAbonnement(membre1.getListeAbonnement());
		Membre result = MemRep.save(membre);
        return ResponseEntity.ok(result);
    }
	
	 @DeleteMapping("/delete-Membre")
	    public String deleteMembre(@RequestParam int id) {
		 MemRep.deleteById(id);
	        return " suppression éffectué";
	    }

}
