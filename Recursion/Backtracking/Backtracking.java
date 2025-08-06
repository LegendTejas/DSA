package Backtracking;

public class Backtracking {
	
	// Recursive function to generate all permutations of a given string
	public static void printPermutation(String str, String perm, int idx) {
		// Base case: if the original string is empty, print the current permutation
		if(str.length() == 0) {
			System.out.println(perm);
			return;
		}
		// Loop through the string and generate all permutations
		for(int i=0; i< str.length(); i++) {
			// Pick the current character
			char currChar = str.charAt(i);
			
			// Create a new string by removing the picked character
			String newStr = str.substring(0,i) + str.substring(i+1);
			
			// Recurse with the new string and updated permutation
			printPermutation(newStr, perm + currChar, idx+1);
		}
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		printPermutation(str, "", 0);
	}

}

// Time Complexity: O(n*n!) we require n steps to get the answer and n! are the total number of answers