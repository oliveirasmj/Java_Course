package com.example._ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example._ProjetoSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{ //UserRepository - camada de acesso a dados dos OrderItemRepository - ex: salvar os dados na BD
	
}
