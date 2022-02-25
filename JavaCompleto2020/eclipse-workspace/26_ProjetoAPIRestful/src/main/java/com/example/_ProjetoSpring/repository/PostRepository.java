package com.example._ProjetoSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example._ProjetoSpring.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //gere um classe do tipo User e do seu ID (que é String)
	
}
