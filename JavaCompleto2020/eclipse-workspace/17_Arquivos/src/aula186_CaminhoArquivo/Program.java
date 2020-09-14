package aula186_CaminhoArquivo;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) { //classe para ver caminhos do arquivo
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath); //criar variavel do tipo File e instanciar com o caminho
		
		System.out.println("getName: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
	}

}
