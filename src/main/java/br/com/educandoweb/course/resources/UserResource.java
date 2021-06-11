package br.com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// Retorna todos os usuarios para a pagina
	// localhost:8080/users
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L , "Maria" , "maria@gmail.com" , "99999-9999" ,"12345");
		return ResponseEntity.ok().body(u);
	}
	
}
