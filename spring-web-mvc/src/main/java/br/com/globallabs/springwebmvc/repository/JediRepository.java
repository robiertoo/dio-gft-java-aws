package br.com.globallabs.springwebmvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.globallabs.springwebmvc.model.Jedi;

@Repository
public class JediRepository {
	private List<Jedi> jedi;
	
	public JediRepository() {
		jedi = new ArrayList<>();
		jedi.add(new Jedi("Luke", "Skylwaker"));
		jedi.add(new Jedi("Obi-wan", "Kenobi"));
		jedi.add(new Jedi("Leia", "Skylwaker"));
	}
	
	public List<Jedi> getAll() {
		return jedi;
	}
	
	public void add(Jedi jedi) {
		this.jedi.add(jedi);
	}
}
