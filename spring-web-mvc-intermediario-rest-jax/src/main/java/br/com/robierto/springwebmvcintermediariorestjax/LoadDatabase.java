package br.com.robierto.springwebmvcintermediariorestjax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.robierto.springwebmvcintermediariorestjax.entity.SoldadoEntity;
import br.com.robierto.springwebmvcintermediariorestjax.repository.SoldadoRepository;

@Configuration
public class LoadDatabase {
	Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(SoldadoRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new SoldadoEntity("Roberto", "46805422841", "Humano", "Cajado", "Vivo")));
			log.info("Preloading " + repository.save(new SoldadoEntity("Roberta", "46805422841", "Humano", "Espada", "Vivo")));
		};
	}
}	
