package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.Category;
import br.com.educandoweb.course.repositories.CategoryRepository;

// SERVE COMO INTERMEDIADOR DO CONTROLLER COM O USUARIO

// TODOS SERVICE TEM QUE TER @Service 
@Service
public class CategoryService{
	
	@Autowired
	private CategoryRepository repository;
	
	// RETORNA TODOS AS CATEGORIAS DO REPOSITORIO
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	// BUSCA A CATEGORIA POR ID
	public Category findById(Long id) {
		Optional<Category> obj= repository.findById(id);
		return obj.get();
	}
}
