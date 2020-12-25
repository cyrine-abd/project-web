
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

import com.example.demo.Dao.TypeActiviteRepository;
import com.example.demo.models.TypeActivite;

@RestController
@RequestMapping
public class TypeActiviteController {
	private final TypeActiviteRepository typeActiviteRepository ;

	@Autowired
	public TypeActiviteController(TypeActiviteRepository TypeActiviteRepository) {
		super();
		this.typeActiviteRepository = TypeActiviteRepository;
	}
	
	@PostMapping("/add-TypeActivite")
    public TypeActivite createTypeActivite( @RequestBody TypeActivite TypeActivite) {
        return typeActiviteRepository.save(TypeActivite);
    }
	@DeleteMapping("/delete-TypeActivite/{id}")
    public String deleteTypeActivite(@PathVariable(value = "id") int id ) {
		
		typeActiviteRepository.deleteById(id);
		return "TypeActivite suprimée!!";
	}
	
	@GetMapping("/TypeActivites")
    public List<TypeActivite> getAll() {
        return typeActiviteRepository.findAll();
    }
	
    @GetMapping("find-TypeActivite/{id}")
    public Optional<TypeActivite> getBiblioById(@PathVariable(value = "id")  int TypeActivite_ID)
    {
		return typeActiviteRepository.findById(TypeActivite_ID);
   
    }
    @PutMapping("update-TypeActivite/{id}")
    public ResponseEntity<TypeActivite> updateTypeActivite(@PathVariable(value = "id") int TypeActivite_Id,
            @RequestBody TypeActivite TypeActivite_Details){
      	Optional<TypeActivite> optionelEntity= typeActiviteRepository.findById(TypeActivite_Id);
          TypeActivite act = optionelEntity.get();
          act.setDescription_typeActivite(TypeActivite_Details.getDescription_typeActivite());               
          final TypeActivite updatedTypeActivite = typeActiviteRepository.save(act);
          return ResponseEntity.ok(updatedTypeActivite);
      }
	

}