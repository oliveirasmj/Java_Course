package com.example._ProjetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.entities.Category;
import com.example._ProjetoSpring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource { //classe que disponibiliza um recurso relativamente aos Categorys - por HTTP - METODO QUE DEVOLVE O QUE É PEDIDO NA URL
	
	@Autowired
	private CategoryService service; //classe para pesquisar na BD
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){ //metodo para aceder a categorias (ResponseEntity - respostas de requisicoes Web)
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}") //agora é passado um id pela url
	public ResponseEntity<Category> findById(@PathVariable Long id) { //metodo para aceder a categoria por id
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
