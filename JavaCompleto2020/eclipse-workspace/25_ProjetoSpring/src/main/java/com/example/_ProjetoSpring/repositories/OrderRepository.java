package com.example._ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example._ProjetoSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{ //OrderRepository - camada de acesso a dados dos Orders - ex: salvar os dados na BD
	
}
