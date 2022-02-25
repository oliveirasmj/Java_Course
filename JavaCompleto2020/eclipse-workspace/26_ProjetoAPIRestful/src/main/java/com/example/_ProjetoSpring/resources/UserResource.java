package com.example._ProjetoSpring.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example._ProjetoSpring.domain.Post;
import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.dto.UserDTO;
import com.example._ProjetoSpring.services.UserService;

@RestController //indicar qual vai ser um recurso rest
@RequestMapping(value = "/users") //indicar o caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service; //Resource(Controlador) vai aceder ao Serviço e o Serviço acede ao Repository
	
	@RequestMapping(method = RequestMethod.GET) //este metodo vai ser um endpoint no caminho /users      OU    @GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){ //metodo para retornar lista de users MAS dentro de um ResponseEntity (retornar HTTP com cabeçalhos e erros)
		
		List<User> list = service.findAll(); //ir buscar os dados à BD
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)) .collect(Collectors.toList()); //converter para listDTO (onde vao apenas os campos necessarios) - podia retornar diretamente o list, mas para optimazar fazemos assim
		
		return ResponseEntity.ok().body(listDto); //retornar list dentro de ResponseEntity no seu body
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) //este metodo tem ainda o id a procurar por url
	public ResponseEntity<UserDTO> findById(@PathVariable String id){ //metodo recebe um id como parametro da URL (@PathVariable)
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj)); //retornar dentro de ResponseEntity no seu body
	}
	
	@RequestMapping(method = RequestMethod.POST) //este metodo vai ser Post    OU    @PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){ //para que o endpoint aceite o objeto - @RequestBody
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); //retornar vazio com o codigo 201 e com o cabecalho com a localizacao do recurso criado
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build(); //quando se faz uma operacao sem retornar nada - no content
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT) //este metodo vai ser Put
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		User obj = service.fromDTO(objDto);
		obj.setId(id); //ter a certeza que o id é mesmo o que veio
		
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts", method = RequestMethod.GET) //este metodo tem ainda o id a procurar por url
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){ //metodo recebe um id como parametro da URL (@PathVariable)
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts()); //retornar dentro de ResponseEntity no seu body
	}
}




//@RequestMapping(method = RequestMethod.GET) //este metodo vai ser um endpoint no caminho /users      OU    @GetMapping
//public List<User> findAll(){ //metodo para retornar lista de users
//	User maria = new User("1", "Maria Brown", "maria@gmail.com");
//	User alex = new User("2", "Alex Green", "alex@gmail.com");
//	
//	List<User> list = new ArrayList<>();
//	list.addAll(Arrays.asList(maria, alex));
//	
//	return list;
//}
