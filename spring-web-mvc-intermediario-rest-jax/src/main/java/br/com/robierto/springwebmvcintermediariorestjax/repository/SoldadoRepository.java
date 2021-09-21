package br.com.robierto.springwebmvcintermediariorestjax.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;

public interface SoldadoRepository extends CrudRepository<SoldadoEntity, Long>{
	List<SoldadoEntity> findAll();
}
