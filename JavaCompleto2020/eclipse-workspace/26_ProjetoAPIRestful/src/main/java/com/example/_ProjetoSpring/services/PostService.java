package com.example._ProjetoSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._ProjetoSpring.domain.Post;
import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.repository.PostRepository;
import com.example._ProjetoSpring.services.exception.ObjectNotFoundException;

//Classe que faz a ligação a Dados

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo; //o Serviço acede ao Repository
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); //retornar se existir senao retorna a excepção
	}
	
}
