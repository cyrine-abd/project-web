
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

import com.example.demo.Dao.ActiviteRepository;
import com.example.demo.Dao.TypeAbonnementRepository;
import com.example.demo.Dao.AboActiviteRepository;
import com.example.demo.models.Activite;
import com.example.demo.models.TypeAbonnement;
import com.example.demo.models.AboActivite;

@RestController
@RequestMapping
public class AboActiviteController {
	private final AboActiviteRepository aboActiviteRepository ;
	private final TypeAbonnementRepository typeAbonnementRepository ;
	private final ActiviteRepository activiteRepository ;



	@Autowired
	public AboActiviteController(AboActiviteRepository AboActiviteRepository) {
		this.typeAbonnementRepository = null;
		this.activiteRepository = null;
		this.aboActiviteRepository = AboActiviteRepository;
	}
	
	@PostMapping("/add-AboActivite")
    public AboActivite createAboActivite( @RequestBody AboActivite aboActivite) {
		Optional<TypeAbonnement> optionalTypeAb = typeAbonnementRepository.findById(aboActivite.typeAbonnement.getId_abonnement());
		aboActivite.setTypeAbonnement(optionalTypeAb.get());
		Optional<Activite> optionalActivite = activiteRepository.findById(aboActivite.activite_id.getId_activite());
		aboActivite.setActivite(optionalActivite.get());
		return aboActiviteRepository.save(aboActivite);
    }
	@DeleteMapping("/delete-AboActivite/{id}")
    public String deleteAboActivite(@PathVariable(value = "id") int id ) {
		
		aboActiviteRepository.deleteById(id);
		return "AboActivite suprimée!!";
	}
	
	@GetMapping("/AboActivites")
    public List<AboActivite> getAll() {
        return aboActiviteRepository.findAll();
    }
	
    @GetMapping("find-AboActivite/{id}")
    public Optional<AboActivite> getBiblioById(@PathVariable(value = "id")  int AboActivite_ID)
    {
		return aboActiviteRepository.findById(AboActivite_ID);
   
    }

}