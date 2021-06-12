package br.com.educandoweb.course.config;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.course.entities.Order;
import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.OrderRepository;
import br.com.educandoweb.course.repositories.UserRepository;

// SETA A CONFIGURACAO PARA TEST

@Configuration
@Profile("test")
// CommandLineRunner é carregado sempre que o programa é inicializado
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		 Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		 Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		 Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		 
		 userRepository.save(u1);
		 userRepository.save(u2);
		 //
		 orderRepository.save(o1);
		 orderRepository.save(o2);
		 orderRepository.save(o3);
	}
}
