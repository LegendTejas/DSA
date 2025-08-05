// Print first and last occurance of an element in string (recursive method)

package Recursion;
import java.util.Scanner;

public class First_LastOcc_Recursive{
	public static int first = -1;
	public static int last = -1;
	
	public static void findOccurance(String str, int idx, char element) {
		if (idx == str.length()) {
			System.out.println("First Occurrence: " + first);
			System.out.println("Last Occurrence: " + last);
			return;
		}
		
		char currChar = str.charAt(idx);
		if (currChar == element) {
			if (first == -1) {
				first = idx;
			} else {
				last = idx;
			}
		}
		
		findOccurance(str, idx + 1, element);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		
		System.out.print("Enter the character to find: ");
		char element = sc.next().charAt(0);
		
		findOccurance(str, 0, element);
		
		sc.close();
		
		//Time Complexity: O(n) where n is string length 
	}
}