package br.com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.course.entities.Product;
import br.com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	// DEPENDENCIA PARA O SERVICE
		@Autowired
		private ProductService service;
		 // AO INVES DE USAR O REPOSITORY USAR O SERVICE
		
	// Retorna todos os produtos para a pagina
	// localhost:8080/products
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		// PASSAR COMO PARAMETRO DA LISTA A CLASS SERVICE QUE IMPLEMENTA O REPOSITORIO
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
	Product obj = service.findById(id);
	return ResponseEntity.ok().body(obj); 
}
}