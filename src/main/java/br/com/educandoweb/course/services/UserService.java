package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.UserRepository;
import br.com.educandoweb.course.services.exceptions.DatabaseException;
import br.com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		// VERIFICA SE PODE RETORNAR O OBJETO ENCONTRADO, CASO NÃO, RETORNA A EXCEÇÃO PERSONALIZADA
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// SALVA NO BANCO DE DADOS UM USUARIO
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// DELETE DO BANCO DE DADOS O USUARIO
	public void delete(Long id) {
		try {
		 repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		/* FAZER ISSO PARA VERIFICAR QUAL A EXCEÇÃO ESTÁ DANDO PARA PODER TRATAR
		 catch(RuntimeException e) {
			e.printStackTrace();
		}*/
	}
	
	//ATUALIZAR UM USUARIO
	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		}

	// METODO RESPONSAVEL PELA ATUALIZACAO DAS INFORMAÇÕES
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
