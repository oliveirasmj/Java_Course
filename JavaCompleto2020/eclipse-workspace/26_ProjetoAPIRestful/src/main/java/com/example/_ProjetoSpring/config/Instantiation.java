package com.example._ProjetoSpring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example._ProjetoSpring.domain.Post;
import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.dto.AuthorDTO;
import com.example._ProjetoSpring.dto.CommentDTO;
import com.example._ProjetoSpring.repository.PostRepository;
import com.example._ProjetoSpring.repository.UserRepository;

@Configuration //classe de configuracao
public class Instantiation implements CommandLineRunner { //CLASSE APENAS DEFINIR ALGUNS REGISTOS AO JNICIAR

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll(); //apagar todos os users que estao na BD
		postRepository.deleteAll(); //apagar todos os posts que estao na BD
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //adicionar à BD
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2)); //adicionar à BD
		
		
		maria.getPosts().addAll(Arrays.asList(post1, post2)); //Associar os post1 e post2 à Maria
		userRepository.save(maria); //Guardar na BD
	}

}
