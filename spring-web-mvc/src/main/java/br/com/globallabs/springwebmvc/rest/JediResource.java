package br.com.globallabs.springwebmvc.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;

@RestController
@RequestMapping("/api")
public class JediResource {
	@Autowired
	private JediRepository repository;
	
	@GetMapping("/jedi")
	public Iterable<Jedi> getAllJedi() {
		return repository.findAll();
	}
	
	@GetMapping("/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable int id) {
		Optional<Jedi> jedi= repository.findById(id);
		
		if(jedi.isPresent()) return ResponseEntity.ok(jedi.get());
		return ResponseEntity.notFound().build();
//		throw new JediNotFoundException();
	}
	
	@PostMapping("/jedi")
	@ResponseStatus(HttpStatus.CREATED)
	public Jedi createJedi(@Valid Jedi jedi) {
		return repository.save(jedi);
	}
	
	@PutMapping("/jedi/{id}")
	
	public ResponseEntity<Jedi> updateJedi(@PathVariable int id, @Valid Jedi dto) {
		Optional<Jedi> jediEntity = repository.findById(id);
		Jedi jedi;
		
		if(jediEntity.isPresent()) jedi = jediEntity.get();
		else return ResponseEntity.notFound().build();
		
		jedi.setName(dto.getName());
		jedi.setLastName(dto.getLastName());
		
		return ResponseEntity.ok(repository.save(jedi));		
	}
	
	@DeleteMapping("/jedi/{id}")
	public ResponseEntity deleteJedi(@PathVariable int id) {
		Optional<Jedi> jediEntity = repository.findById(id);
		
		if(jediEntity.isEmpty()) return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
