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

import com.example.demo.Dao.CoachRepository;
import com.example.demo.Dao.SalleRepository;
import com.example.demo.models.Coach;
import com.example.demo.models.Salle;





@RestController
@RequestMapping("coach")
public class CoachController {
	private final CoachRepository coachRepository ;
	private final SalleRepository salleRepository ;


	@Autowired
	public CoachController(CoachRepository coachRepository) {
		this.salleRepository = null;
		this.coachRepository = coachRepository;
	}
	
	@PostMapping()
    public Coach createCoach( @RequestBody Coach coach) {
		Optional<Salle> optionalSalle = salleRepository.findById(coach.salle_coach.getId_salle());
		coach.setSalle_coach(optionalSalle.get());
        return coachRepository.save(coach);
    }
	
	@DeleteMapping("/{id}")
    public String deleteCoach(@PathVariable(value = "id") int id ) {
		
		coachRepository.deleteById(id);
		return "Coach suprimer!!";
	}
	
	@GetMapping
    public List<Coach> getAll() {
        return coachRepository.findAll();
    }
	
    @GetMapping("/{id}")
    public Optional<Coach> getBiblioById(@PathVariable(value = "id")  int coach_ID)
    {
		return coachRepository.findById(coach_ID);
   
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable(value = "id") int coach_Id,
            @RequestBody Coach coach_Details){
      	Optional<Coach> optionelEntity= coachRepository.findById(coach_Id);
      	Coach coach = optionelEntity.get();
      	coach.setNom_coach(coach_Details.getNom_coach());
        coach.setPrenom_coach(coach_Details.getPrenom_coach());
        coach.setTel_coach(coach_Details.getTel_coach());
        
      	
      	final Coach updatedCoach = coachRepository.save(coach);
        return ResponseEntity.ok(updatedCoach);
        }

}
    