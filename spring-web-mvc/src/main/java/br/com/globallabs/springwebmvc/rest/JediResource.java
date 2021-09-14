package br.com.globallabs.springwebmvc.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;
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
	public Jedi getJedi(@PathVariable int id) {
		Optional<Jedi> jedi= repository.findById(id);
		
		if(jedi.isPresent()) return jedi.get();
		throw new JediNotFoundException();
	}
	
	@PostMapping("/jedi")
	public Jedi createJedi(@Valid Jedi jedi) {
		return repository.save(jedi);
	}
}
