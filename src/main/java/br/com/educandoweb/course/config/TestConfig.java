package br.com.educandoweb.course.config;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.course.entities.Category;
import br.com.educandoweb.course.entities.Order;
import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.entities.enums.OrderStatus;
import br.com.educandoweb.course.repositories.CategoryRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		 
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		 Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		 Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		 Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		 
		 userRepository.save(u1);
		 userRepository.save(u2);
		 //
		 orderRepository.save(o1);
		 orderRepository.save(o2);
		 orderRepository.save(o3);
	}
}
