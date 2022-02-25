package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa1_Inserir { //CRIAR BD E INSERIR DADOS 

	public static void main(String[] args) {
		
		//Executar na primeira vez
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		//Conexao com a BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //nome que está na linha 7 da classe src/main/resources/META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); //iniciar transacao
		
		//Salvar as pessoas na BD
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit(); //concluir transacao
		System.out.println("Pronto");
		
		//Fechar o em e o emf
		em.close();
		emf.close();
	}

}