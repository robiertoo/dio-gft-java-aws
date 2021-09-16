package br.com.robierto.springwebmvcintermediariorestjax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robierto.springwebmvcintermediariorestjax.controller.request.SoldadoEditRequest;
import br.com.robierto.springwebmvcintermediariorestjax.dto.Soldado;
import br.com.robierto.springwebmvcintermediariorestjax.service.SoldadoService;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {
	
	@Autowired
	private SoldadoService service;
	
	@GetMapping
	public ResponseEntity<List<Soldado>> buscarSoldados() {
		List<Soldado> soldados = service.buscarSoldados();
		return ResponseEntity.ok(soldados);
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Soldado> buscarSoldado(@PathVariable String cpf) {
		Soldado soldado = service.buscarSoldado(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(soldado);
	}
	
	@PostMapping
	public ResponseEntity<Soldado> criarSoldado(@RequestBody Soldado dto) {
		Soldado soldado = service.criarSoldado(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(soldado);
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Soldado> editarSoldado(@PathVariable String cpf, @RequestBody SoldadoEditRequest seq) {
		service.alterarSoldado(cpf, seq);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Soldado> deletarSoldado(@PathVariable String cpf) {
		service.deletarSoldado(cpf);
		return ResponseEntity.ok().build();
	}
}
