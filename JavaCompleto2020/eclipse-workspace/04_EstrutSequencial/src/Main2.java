import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double R, A, pi = 3.14159;
	    
	    R = sc.nextDouble();

	    //A = pi * R * R;
	    A = pi * Math.pow(R, 2);

	    System.out.printf("A=%.4f%n", A);

		sc.close();

	}

}
