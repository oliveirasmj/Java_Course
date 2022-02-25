package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa3_Eliminar { //ELIMINAR DADOS

	public static void main(String[] args) {
		
		//Conexao com a BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //nome que está na linha 7 da classe src/main/resources/META-INF/persistence.xml
		EntityManager em= emf.createEntityManager();
		
		//Sempre que nao for uma simples consulta é necessário fazer uma transacao
		em.getTransaction().begin(); //iniciar transacao
		Pessoa p = em.find(Pessoa.class, 2); //Procurar a pessoa com o id 2
		em.remove(p);
		em.getTransaction().commit(); //concluir transacao

		System.out.println("Pronto");
		//Fechar o em e o emf
		em.close();
		emf.close();
	}

}