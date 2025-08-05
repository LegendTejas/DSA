package Recursion;
import java.util.Scanner;

public class Factorial {
	public static void printFactorial(int n, int fact) {
		if (n == 0) {
			System.out.println("Factorial: " + fact);
			return;
		}
		
		fact *= n;
		printFactorial(n - 1, fact);
	}
  
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();

		printFactorial(n, 1);
		sc.close();
	}
}