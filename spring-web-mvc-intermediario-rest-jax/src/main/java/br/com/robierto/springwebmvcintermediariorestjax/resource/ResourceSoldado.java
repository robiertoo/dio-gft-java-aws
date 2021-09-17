package br.com.robierto.springwebmvcintermediariorestjax.resource;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.robierto.springwebmvcintermediariorestjax.controller.SoldadoController;
import br.com.robierto.springwebmvcintermediariorestjax.controller.response.SoldadoListResponse;
import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResourceSoldado {
	private ObjectMapper objectMapper;

	public ResourceSoldado() {
		// TODO Auto-generated constructor stub
	}

	public ResourceSoldado(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}

	public SoldadoListResponse criarLink(SoldadoEntity entity) {
		SoldadoListResponse soldadoListResponse = objectMapper
				.convertValue(entity, SoldadoListResponse.class);
		Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(entity.getId())).withSelfRel();
		soldadoListResponse.add(link);
		return soldadoListResponse;
	}
}
