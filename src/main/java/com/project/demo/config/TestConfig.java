package com.project.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demo.entities.User;
import com.project.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria do Carmo", "maria@123", "987654321","98765421",null, "senha", 1000.0);
		User u2 = new User(null, "Carlos Dantas", "carlos@123", "987654321", "98765421",null, "senha", 5000.0);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
