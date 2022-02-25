package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa2_Consultar {//CONSULTAR DADOS

	public static void main(String[] args) {
		//Inserir primeiro os dados do Program 1
		
		//Conexao com a BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //nome que está na linha 7 da classe src/main/resources/META-INF/persistence.xml
		EntityManager em= emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2); //Procurar a pessoa com o id 2
		System.out.println(p);

		System.out.println("Pronto");
		//Fechar o em e o emf
		em.close();
		emf.close();
	}

}