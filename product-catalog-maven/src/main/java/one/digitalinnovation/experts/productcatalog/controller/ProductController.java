package one.digitalinnovation.experts.productcatalog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.experts.productcatalog.model.Product;
import one.digitalinnovation.experts.productcatalog.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	Iterable<Product> getAll() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Product> findById(@PathVariable Long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping
	Product create(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
