package br.com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// RETORNA UM USUARIO PELO ID
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj); 
}
	
	// INSERIR UM USUARIO NO BANCO DE DADOS PELO POST
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	// DELETAR UMA INFORMAÇÃO [ USUARIO ] DO BANCO DE DADOS
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
 		return ResponseEntity.noContent().build();
	}
	
	// ATUALIZAÇÃO DE UM USUARIO
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}