package secao6;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		while (x!=0 && y!=0) {
			//ver o quadrante a que pertence
			if(x>0 && y>0) {
				System.out.println("primeiro");
			} else if(x>0 && y<0){
				System.out.println("quarto");
			} else if(x<0 && y<0){
				System.out.println("terceiro");
			} else if(x<0 && y>0){
				System.out.println("segundo");
			}
			//ler novamente variaveis
			x = sc.nextInt();
			y = sc.nextInt();
		}
		sc.close();
	}

}
