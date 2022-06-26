package com.project.demo.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Order;
import com.project.demo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResouce {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List> findall() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findBuyId(@PathVariable Long id) {
		Order obj = service.findBuyId(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
