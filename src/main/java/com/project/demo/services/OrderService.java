package com.project.demo.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.Order;
import com.project.demo.entities.User;
import com.project.demo.entities.Order;
import com.project.demo.repositories.OrderRepository;
import com.project.demo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private OrderRepository userRepository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	public Order insert(Order obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Order update(Long id, Order obj) {
		Order entity = userRepository.getReferenceById(id);

		updateData(entity, obj);
		return userRepository.save(entity);
	}

	private void updateData(Order entity, Order obj) {
		entity.setAmount(obj.getAmount());

	}
}
