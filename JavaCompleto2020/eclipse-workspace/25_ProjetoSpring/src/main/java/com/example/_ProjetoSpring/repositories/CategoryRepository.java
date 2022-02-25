package com.example._ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example._ProjetoSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{ //UserRepository - camada de acesso a dados dos Category - ex: salvar os dados na BD
	
}
