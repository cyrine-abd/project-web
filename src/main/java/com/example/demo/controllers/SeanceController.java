
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
import com.example.demo.Dao.CoachRepository;
import com.example.demo.Dao.SeanceRepository;
import com.example.demo.models.Activite;
import com.example.demo.models.Coach;
import com.example.demo.models.Seance;

@RestController
@RequestMapping
public class SeanceController {
	private final SeanceRepository seanceRepository ;
	private final CoachRepository coachRepository ;
	private final ActiviteRepository activiteRepository ;



	@Autowired
	public SeanceController(SeanceRepository seanceRepository) {
		this.coachRepository = null;
		this.activiteRepository = null;
		this.seanceRepository = seanceRepository;
	}
	
	@PostMapping("/add-Seance")
    public Seance createSeance( @RequestBody Seance seance) {
		Optional<Coach> optionalSalle = coachRepository.findById(seance.seance_coach.getId_coach());
		seance.setSeance_coach(optionalSalle.get());
		Optional<Activite> optionalActivite = activiteRepository.findById(seance.activite_seance.getId_activite());
		seance.setActivite_seance(optionalActivite.get());
		return seanceRepository.save(seance);
    }
	@DeleteMapping("/delete-Seance/{id}")
    public String deleteSeance(@PathVariable(value = "id") int id ) {
		
		seanceRepository.deleteById(id);
		return "Seance suprimée!!";
	}
	
	@GetMapping("/Seances")
    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }
	
    @GetMapping("find-Seance/{id}")
    public Optional<Seance> getBiblioById(@PathVariable(value = "id")  int Seance_ID)
    {
		return seanceRepository.findById(Seance_ID);
   
    }
    @PutMapping("update-Seance/{id}")
    public ResponseEntity<Seance> updateSeance(@PathVariable(value = "id") int Seance_Id,
            @RequestBody Seance Seance_Details){
      	Optional<Seance> optionelEntity= seanceRepository.findById(Seance_Id);
          Seance seance = optionelEntity.get();
          seance.setDebut_Seance(Seance_Details.getDebut_Seance());
          seance.setFin_Seance(Seance_Details.getFin_Seance());
          seance.setPresence(Seance_Details.isPresence());                   
          final Seance updatedSeance = seanceRepository.save(seance);
          return ResponseEntity.ok(updatedSeance);
      }
	

}