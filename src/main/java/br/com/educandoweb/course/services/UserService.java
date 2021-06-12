package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.UserRepository;

// SERVE COMO INTERMEDIADOR DO CONTROLLER COM O USUARIO

// TODOS SERVICE TEM QUE TER @Service 
@Service
public class UserService{
	
	@Autowired
	private UserRepository repository;
	
	// RETORNA TODOS OS USUARIOS DO REPOSITORIO
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// BUSCA O USUARIO POR ID
	public User findById(Long id) {
		Optional<User> obj= repository.findById(id);
		return obj.get();
	}
}
