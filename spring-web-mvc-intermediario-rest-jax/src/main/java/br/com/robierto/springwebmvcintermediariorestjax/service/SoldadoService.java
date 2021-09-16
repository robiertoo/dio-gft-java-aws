package br.com.robierto.springwebmvcintermediariorestjax.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.robierto.springwebmvcintermediariorestjax.controller.request.SoldadoEditRequest;
import br.com.robierto.springwebmvcintermediariorestjax.dto.Soldado;

@Service
public class SoldadoService {
	
	public Soldado buscarSoldado(String cpf) {
		Soldado soldado = new Soldado(cpf, "Legolas", "Elfo", "Arco e Flecha");
		return soldado;
	}
	
	public Soldado criarSoldado(Soldado soldado) {
		return soldado;
	}

	public void alterarSoldado(String cpf, SoldadoEditRequest seq) {
		
	}

	public void deletarSoldado(String cpf) {
		
	}

	public List<Soldado> buscarSoldados() {
		List<Soldado> soldados = new ArrayList<>();
		
		Soldado soldado1 = new Soldado("12345789", "Gimli", "Anão", "Machado");
		Soldado soldado2 = new Soldado("987654321", "Aragorn", "Humano", "Espada");
		
		
		soldados = Arrays.asList(soldado1, soldado2);
		
		return soldados;
	}
}
