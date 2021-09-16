package br.com.globallabs.springwebmvc.rest.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;
import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;

@Service
public class JediService {
	
	@Autowired
	private JediRepository repository;

	public Iterable<Jedi> findAll() {
		return repository.findAll();
	}

	public Jedi findById(int id) {
		Optional<Jedi> jedi = repository.findById(id);
		if(jedi.isPresent()) return jedi.get();
		throw new JediNotFoundException();
	}

	public Jedi save(@Valid Jedi jedi) {
		return repository.save(jedi);
	}

	public Jedi update(int id, @Valid Jedi dto) {
		Jedi jedi = this.findById(id);

		jedi.setName(dto.getName());
		jedi.setLastName(dto.getLastName());

		return repository.save(jedi);
	}

	public ResponseEntity deleteById(int id) {
		Jedi jediEntity = this.findById(id);
		repository.deleteById(id);
	}

}
