package com.example._ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example._ProjetoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{ //UserRepository - camada de acesso a dados dos Users - ex: salvar os dados na BD
	
}
