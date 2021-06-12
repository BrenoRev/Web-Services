package br.com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// DEPENDENCIA PARA O SERVICE
		@Autowired
		private UserService service;
		 // AO INVES DE USAR O REPOSITORY USAR O SERVICE
		
	// Retorna todos os usuarios para a pagina
	// localhost:8080/users
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		// PASSAR COMO PARAMETRO DA LISTA A CLASS SERVICE QUE IMPLEMENTA O REPOSITORIO
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj); 
}
}