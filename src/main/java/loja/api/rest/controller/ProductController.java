package loja.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
import jakarta.validation.Valid;
import loja.api.rest.model.Product;
import loja.api.rest.repository.ProductRepository;



@RestController /* Arquitetura REST */
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(value = "/", produces = "application/json")
	@CachePut("cacheproduct")
    public ResponseEntity<Product> cadastrarProduct(@RequestBody @Valid Product product) {



		Product productSave = productRepository.save(product);


		return new ResponseEntity<Product>(productSave, HttpStatus.OK);

	}
	

	@GetMapping(value = "/", produces = "application/json")
	@CachePut("cacheproduct")
	public ResponseEntity<List<Product>> product() throws InterruptedException {

		

		List<Product> list = productRepository.findAll();

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Product> atualizar(@RequestBody Product product) {

	


		Product productSave = productRepository.save(product);

		return new ResponseEntity<Product>(productSave, HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
	    productRepository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
}
