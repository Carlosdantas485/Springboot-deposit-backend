package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
