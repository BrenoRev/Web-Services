package br.com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.course.entities.Order;
import br.com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	// DEPENDENCIA PARA O SERVICE
		@Autowired
		private OrderService service;
		 // AO INVES DE USAR O REPOSITORY USAR O SERVICE
		
	// Retorna todos os pedidos para a pagina
	// localhost:8080/Orders
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		// PASSAR COMO PARAMETRO DA LISTA A CLASS SERVICE QUE IMPLEMENTA O REPOSITORIO
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
	Order obj = service.findById(id);
	return ResponseEntity.ok().body(obj); 
}
}