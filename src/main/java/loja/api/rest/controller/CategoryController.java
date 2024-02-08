package loja.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import loja.api.rest.model.Category;

import loja.api.rest.repository.CategoryRepository;


@RestController /* Arquitetura REST */
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping(value = "/", produces = "application/json")
	@CachePut("cachecategory")
    public ResponseEntity<Category> cadastrarCategory(@RequestBody @Valid Category category) {


		Category categorySave = categoryRepository.save(category);


		return new ResponseEntity<Category>(categorySave, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/", produces = "application/json")
	@CachePut("cachecategory")
	public ResponseEntity<List<Category>> category() throws InterruptedException {

		

		List<Category> list = categoryRepository.findAll();

		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	
	
}
