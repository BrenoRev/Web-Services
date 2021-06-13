package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.Product;
import br.com.educandoweb.course.repositories.ProductRepository;

// SERVE COMO INTERMEDIADOR DO CONTROLLER COM O USUARIO

// TODOS SERVICE TEM QUE TER @Service 
@Service
public class ProductService{
	
	@Autowired
	private ProductRepository repository;
	
	// RETORNA TODOS OS USUARIOS DO REPOSITORIO
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	// BUSCA O USUARIO POR ID
	public Product findById(Long id) {
		Optional<Product> obj= repository.findById(id);
		return obj.get();
	}
}
