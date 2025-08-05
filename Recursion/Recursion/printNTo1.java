package Recursion;
import java.util.Scanner;


public class printNTo1 {
	
	// Recursive method to print numbers from n to 1
	public static void printNum(int n) {
		// Base case: If n reaches 0, stop the recursion
		if(n == 0) {
			return;
		}
		// Print the current number
		System.out.println(n);
		
		// Recursive call with n-1 to print the next number
		printNum(n-1); 
	}
	
	// Main method
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// Call the recursive function to print numbers from n to 1
		printNum(n);
		
		sc.close();
	}

}
