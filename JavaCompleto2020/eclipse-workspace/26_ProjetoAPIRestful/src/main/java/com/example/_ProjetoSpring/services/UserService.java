package com.example._ProjetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.dto.UserDTO;
import com.example._ProjetoSpring.repository.UserRepository;
import com.example._ProjetoSpring.services.exception.ObjectNotFoundException;

//Classe que faz a ligação a Dados

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; //o Serviço acede ao Repository
	
	public List<User> findAll(){
		return repo.findAll(); //metodo que retorna todos os objetos na BD do tipo User
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); //retornar se existir senao retorna a excepção
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId()); //ir buscar o objeto como parametro à BD
		updateData(newObj, obj); //atualizar o objeto para os dados como parametro
		return repo.save(newObj); //guardar o objeto atualizado
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName()); //atualizar os dados
		newObj.setEmail(obj.getEmail()); //atualizar os dados
	}

	public User fromDTO(UserDTO objDto) { //Converter de userDto para User
		return new User (objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
