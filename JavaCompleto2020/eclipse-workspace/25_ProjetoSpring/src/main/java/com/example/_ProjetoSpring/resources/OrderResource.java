package com.example._ProjetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.entities.Order;
import com.example._ProjetoSpring.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { //classe que disponibiliza um recurso relativamente aos Orders - por HTTP - METODO QUE DEVOLVE O QUE É PEDIDO NA URL
	
	@Autowired
	private OrderService service; //classe para pesquisar na BD
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){ //metodo para aceder aos orders (ResponseEntity - respostas de requisicoes Web)
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}") //agora é passado um id pela url
	public ResponseEntity<Order> findById(@PathVariable Long id) { //metodo para aceder ao usuario por id
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
