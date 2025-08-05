package Recursion;
import java.util.Scanner;

public class ReverseString {
	
	public static void printRev(String str, int idx) {
		// Base Case: when index is 0, print the first character and return
		if (idx == 0) {
			System.out.print(str.charAt(idx));
			return;
		}
		
		// Recursive Case: print the current character and call function for previous index
		System.out.print(str.charAt(idx));
		printRev(str, idx - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = sc.nextLine(); 
		
		System.out.print("Reversed String: ");
		printRev(str, str.length() - 1);
		
		sc.close();
	}
}


////iterative method

//String input = "TejasTp";
//String reversed = "";
//for (int i = input.length() - 1; i >= 0; i--) {
//reversed += input.charAt(i);
//}