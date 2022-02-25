package com.example._ProjetoSpring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.domain.Post;
import com.example._ProjetoSpring.services.PostService;

@RestController //indicar qual vai ser um recurso rest
@RequestMapping(value = "/posts") //indicar o caminho do endpoint
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) //este metodo tem ainda o id a procurar por url
	public ResponseEntity<Post> findById(@PathVariable String id){ //metodo recebe um id como parametro da URL (@PathVariable)
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //retornar dentro de ResponseEntity no seu body
	}
	
}