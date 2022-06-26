package com.project.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demo.entities.Order;
import com.project.demo.entities.User;
import com.project.demo.enums.OrderStatus;
import com.project.demo.repositories.OrderRepository;
import com.project.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria do Carmo", "maria@123", "987654321","98765421",null, "senha", 1000.0);
		User u2 = new User(null, "Carlos Dantas", "carlos@123", "987654321", "98765421",null, "senha", 5000.0);
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10z"), OrderStatus.WAITING_PAYMANT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22z"), OrderStatus.WAITING_PAYMANT, u1);

		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
}
