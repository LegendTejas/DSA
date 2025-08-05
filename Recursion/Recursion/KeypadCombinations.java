// Print keypad Combination (old keypad of mobile)

// Keypad:
// 0 -> .
// 1 -> abc
// 2 -> def
// 3 -> ghi
// 4 -> jkl
// 5 -> mno
// 6 -> pqrs
// 7 -> tu
// 8 -> vwx
// 9 -> yz


// keypad combination example: 23
// for 2 and 3 the combinations are:
//dg
//dh
//di
//eg
//eh
//ei
//fg
//fh
//fi

package Recursion;

public class KeypadCombinations {
	
	// Keypad mapping as per mobile keypad where index represents the digit
	public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
	
	// Recursive function to generate and print all possible letter combinations
	public static void printCombination(String str, int idx, String combination) {
		
		// Base case: if we've processed all digits, print the current combination
		if(idx == str.length()) {
			System.out.println(combination);
			return;
		}
		
		// Get the current digit from the string
		char currChar = str.charAt(idx);
		
		// Get the corresponding characters from the keypad mapping
		String mapping = keypad[currChar - '0'];
		
		// Recursively try each character for the current digit
		for(int i=0; i<mapping.length(); i++) {
			printCombination(str, idx+1, combination+mapping.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		String str = "23";
		printCombination(str, 0, ""); // Start recursion from index 0 and empty combination
	}

}

// Time Complexity: O(k^n) where k = max number of letters per digit(<=4)