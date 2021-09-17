package br.com.robierto.springwebmvcintermediariorestjax.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.robierto.springwebmvcintermediariorestjax.controller.request.SoldadoEditRequest;
import br.com.robierto.springwebmvcintermediariorestjax.controller.response.SoldadoResponse;
import br.com.robierto.springwebmvcintermediariorestjax.dto.Soldado;
import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;
import br.com.robierto.springwebmvcintermediariorestjax.repository.SoldadoRepository;

@Service
public class SoldadoService {
	
	private SoldadoRepository repository;
	private ObjectMapper objectMapper;
	
	public SoldadoService(SoldadoRepository repository, ObjectMapper objectMapper) {
		this.repository = repository;
		this.objectMapper = objectMapper;
	}
	
	public SoldadoResponse buscarSoldado(int id) {
		SoldadoEntity soldado = repository.findById(id).orElseThrow();
		SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
		return soldadoResponse;
	}
	
	public void criarSoldado(Soldado soldado) {
		SoldadoEntity entity = objectMapper.convertValue(soldado, SoldadoEntity.class);
		repository.save(entity);
	}

	public void alterarSoldado(int id, SoldadoEditRequest seq) {
		SoldadoEntity entity = objectMapper.convertValue(seq, SoldadoEntity.class);
		entity.setId(id);
		repository.save(entity);
	}

	public void deletarSoldado(int id) {
		SoldadoEntity entity = repository.findById(id).orElseThrow();
		repository.delete(entity);
	}

	public List<Soldado> buscarSoldados() {
		Iterable<SoldadoEntity> all = repository.findAll();
		List<Soldado> soldadoStream =  StreamSupport.stream(all.spliterator(), false)
				.map(it -> objectMapper.convertValue(it, Soldado.class))
				.collect(Collectors.toList());
		return soldadoStream;
	}
}
