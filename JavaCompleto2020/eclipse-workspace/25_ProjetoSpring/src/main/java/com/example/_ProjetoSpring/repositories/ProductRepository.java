package com.example._ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example._ProjetoSpring.entities.Category;
import com.example._ProjetoSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ //UserRepository - camada de acesso a dados dos Products - ex: salvar os dados na BD
	
}
