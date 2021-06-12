package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.Order;
import br.com.educandoweb.course.repositories.OrderRepository;

// SERVE COMO INTERMEDIADOR DO CONTROLLER COM O USUARIO

// TODOS SERVICE TEM QUE TER @Service 
@Service
public class OrderService{
	
	@Autowired
	private OrderRepository repository;
	
	// RETORNA TODOS OS PEDIDOS DO REPOSITORIO
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	// BUSCA O PEDIDO POR ID
	public Order findById(Long id) {
		Optional<Order> obj= repository.findById(id);
		return obj.get();
	}
}
