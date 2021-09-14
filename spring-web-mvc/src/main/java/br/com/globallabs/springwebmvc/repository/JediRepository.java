package br.com.globallabs.springwebmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.globallabs.springwebmvc.model.Jedi;

@Repository
public interface JediRepository extends CrudRepository<Jedi, Integer>{
	
}
