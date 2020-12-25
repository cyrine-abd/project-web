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

import com.example.demo.Dao.AbonnementRepository;
import com.example.demo.Dao.MembreRepository;
import com.example.demo.Dao.TypeAbonnementRepository;
import com.example.demo.models.Abonnement;
import com.example.demo.models.Membre;
import com.example.demo.models.Abonnement;
import com.example.demo.models.Salle;
import com.example.demo.models.TypeAbonnement;


@RestController
@RequestMapping("abonnement")
public class AbonnementController {
	
	private final TypeAbonnementRepository typeAbonnementRepository ;
	private final AbonnementRepository abonnementRepository ;
    private final MembreRepository membreRepository ;
    
	
	
	public AbonnementController(TypeAbonnementRepository typeAbonnementRepository,
			AbonnementRepository abonnementRepository, MembreRepository membreRepository) {
		super();
		this.typeAbonnementRepository = typeAbonnementRepository;
		this.abonnementRepository = abonnementRepository;
		this.membreRepository = membreRepository;
	}
	@PostMapping()
    public Abonnement createAbonnement( @RequestBody Abonnement abonnement) {
		Optional<TypeAbonnement> optionalTypeAbonnement = typeAbonnementRepository.findById(abonnement.getTypeAbonnement().getId_abonnement());
		abonnement.setTypeAbonnement(optionalTypeAbonnement.get());
		
		Optional<Membre> optionalMembre = membreRepository.findById(abonnement.getMembre().getId_membre());
		abonnement.setMembre(optionalMembre.get());
		return abonnementRepository.save(abonnement);
    }

	@DeleteMapping("/{id}")
    public String deleteAbonnement(@PathVariable(value = "id") int id ) {
		
		abonnementRepository.deleteById(id);
		return "Abonnement suprimer!!";
	}
	
	@GetMapping
    public List<Abonnement> getAll() {
        return abonnementRepository.findAll();
    }
	
    @GetMapping("/{id}")
    public Optional<Abonnement> getBiblioById(@PathVariable(value = "id")  int abonnement_ID)
    {
		return abonnementRepository.findById(abonnement_ID);
   
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable(value = "id") int abonnement_Id,
            @RequestBody Abonnement abonnement_Details){
      	Optional<Abonnement> optionelEntity= abonnementRepository.findById(abonnement_Id);
      	Abonnement abonnement = optionelEntity.get();
      	abonnement.setDate_Abonner(abonnement_Details.getDate_Abonner());
      	
      	final Abonnement updatedAbonnement = abonnementRepository.save(abonnement);
        return ResponseEntity.ok(updatedAbonnement);
        }
    
    

}