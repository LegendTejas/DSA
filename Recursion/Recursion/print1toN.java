package Recursion;
import java.util.*;

public class print1toN {
	// recursion method
	public static void printNum(int i, int n) {
		// Base case
		if (i > n) {
			return;
		}
		System.out.println(i);
		printNum(i + 1, n);
	}
	 
	// main method
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		printNum(1, n); // Start from 1 to n
		sc.close();
		
	}
}