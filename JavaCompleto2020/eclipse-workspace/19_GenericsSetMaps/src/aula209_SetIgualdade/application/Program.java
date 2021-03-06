package aula209_SetIgualdade.application;

import java.util.HashSet;
import java.util.Set;

import aula209_SetIgualdade.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Set<Product> set = new HashSet<>();
		
		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));
		
		Product prod = new Product("Notebook", 1200.0); //instanciar um novo produto igual a um do conjunto
		
		System.out.println(set.contains(prod)); //testar se o produto existe no conjunto
		//da falso porque a classe produto nao contem os metodos HashCode e Equals - compara por referencia de ponteiros e n�o por conteudo
		//SOLUCAO: colocar os metodos hacode e equals nao classe Produto - pois assim compara pelos valores
		
		System.out.println("------");
		set.add(prod); //ele vai portanto colocar porque pensa ser diferente - se tiver HashCode e Equals na classe Product j� n�o adiciona
		System.out.println();
		for(Product p : set) {
			System.out.println(p.getName() + " - " + p.getPrice());
		}
	}

}
