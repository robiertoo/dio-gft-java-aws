package br.com.robierto.springwebmvcintermediariorestjax.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.robierto.springwebmvcintermediariorestjax.controller.SoldadoController;
import br.com.robierto.springwebmvcintermediariorestjax.controller.response.SoldadoListResponse;
import br.com.robierto.springwebmvcintermediariorestjax.controller.response.SoldadoResponse;
import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;

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
	
	public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity) {
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).withSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }
	
	 public SoldadoResponse criarLinkDetalhe(SoldadoEntity soldadoEntity) {
	        SoldadoResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoResponse.class);
	        if(soldadoEntity.getStatus().equals("morto")){
	            Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldadoEntity.getId()))
	                    .withRel("remover")
	                    .withTitle("Deletar soldado")
	                    .withType("delete");
	            soldadoListResponse.add(link);
	        }else if(soldadoEntity.getStatus().equals("vivo")) {
	            Link link = linkTo(methodOn(SoldadoController.class).frenteCastelo(soldadoEntity.getId()))
	                    .withRel("batalhar")
	                    .withTitle("Ir para frente do castelo")
	                    .withType("put");
	            soldadoListResponse.add(link);
	        }
	        return soldadoListResponse;
	    }
}
