package secao5;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduza um n�mero: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num % 2 == 0) {
			System.out.println("Par");
		}
		else{
			System.out.println("Impar");
		}
		
		sc.close();
	}

}
