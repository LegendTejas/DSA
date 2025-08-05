package Recursion;
import java.util.Scanner;

public class FibonacciSeries {
	public static void Fibo(int a, int b, int n) {
		// a -> second last term, b -> last term, n -> no. of terms
		if (n == 0) {
			return;
		}
		int c = a + b;
		System.out.print(c+" ");
		Fibo(b, c, n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the limit: ");
		int n = sc.nextInt();
		
		int a = 0, b = 1;
		System.out.print(a+" ");
		System.out.print(b+" ");
		Fibo(a, b, n-2);
		
		sc.close();
	}

}
