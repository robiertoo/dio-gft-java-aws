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
import br.com.globallabs.springwebmvc.rest.service.JediService;

@RestController
@RequestMapping("/api")
public class JediResource {

	@Autowired
	private JediService service;

	@GetMapping("/jedi")
	public Iterable<Jedi> getAllJedi() {
		return service.findAll();
	}

	@GetMapping("/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable int id) {
		Jedi jedi = service.findById(id);
		return ResponseEntity.ok(jedi);
	}

	@PostMapping("/jedi")
	@ResponseStatus(HttpStatus.CREATED)
	public Jedi createJedi(@Valid Jedi jedi) {
		return service.save(jedi);
	}

	@PutMapping("/jedi/{id}")

	public ResponseEntity<Jedi> updateJedi(@PathVariable int id, @Valid Jedi dto) {
		Jedi jedi = service.update(id, dto);
		return ResponseEntity.ok(jedi);
	}

	@DeleteMapping("/jedi/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteJedi(@PathVariable int id) {		
		service.deleteById(id);
	}
}
