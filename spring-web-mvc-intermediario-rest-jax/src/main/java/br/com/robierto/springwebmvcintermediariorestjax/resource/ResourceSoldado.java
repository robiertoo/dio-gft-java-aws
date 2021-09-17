package br.com.robierto.springwebmvcintermediariorestjax.resource;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.robierto.springwebmvcintermediariorestjax.controller.SoldadoController;
import br.com.robierto.springwebmvcintermediariorestjax.controller.response.SoldadoListResponse;
import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;


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
		SoldadoListResponse soldadoListResponse = objectMapper.convertValue(entity, SoldadoListResponse.class);
		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldadoController.class).buscarSoldado(entity.getId())).withSelfRel();
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(SoldadoController.class).buscarSoldado(SoldadoEntity.getId())).withSelfRel();
		
//		ControllerLinkRelationProvider linkTo = linkTo.(method)
//		soldadoListResponse.add(null);
	}
}
