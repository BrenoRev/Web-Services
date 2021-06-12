package br.com.educandoweb.course.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.UserRepository;

// SETA A CONFIGURACAO PARA TEST

@Configuration
@Profile("test")
// CommandLineRunner é carregado sempre que o programa é inicializado
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		 userRepository.save(u1);
		 userRepository.save(u2);
	}
}
