package com.example._ProjetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._ProjetoSpring.entities.Order;
import com.example._ProjetoSpring.repositories.OrderRepository;

@Service
public class OrderService { //classe para pesquisar na BD
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
