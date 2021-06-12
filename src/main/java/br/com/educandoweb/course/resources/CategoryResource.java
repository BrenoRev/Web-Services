package br.com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.course.entities.Category;
import br.com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	// DEPENDENCIA PARA O SERVICE
		@Autowired
		private CategoryService service;
		 // AO INVES DE USAR O REPOSITORY USAR O SERVICE
		
	// Retorna todos as categoria para a pagina
	// localhost:8080/users
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		// PASSAR COMO PARAMETRO DA LISTA A CLASS SERVICE QUE IMPLEMENTA O REPOSITORIO
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
	Category obj = service.findById(id);
	return ResponseEntity.ok().body(obj); 
}
}