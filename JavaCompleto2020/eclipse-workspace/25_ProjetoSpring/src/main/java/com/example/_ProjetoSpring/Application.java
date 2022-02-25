package com.example._ProjetoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { //ligar Apache e TomCat antes de executar

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
