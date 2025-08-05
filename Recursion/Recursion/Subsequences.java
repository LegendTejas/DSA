// print all the subsequences of a string
// Time Complexity: O(2^n)

package Recursion;

public class Subsequences {

    // Recursive function to print all subsequences of the given string
    public static void printSubsequences(String str, int idx, String newStr) {
        // Base Case: If we've processed all characters
        if (idx == str.length()) {
            System.out.println(newStr);  // Print the formed subsequence
            return;
        }

        char currChar = str.charAt(idx);

        // Include the current character
        printSubsequences(str, idx + 1, newStr + currChar);

        // Exclude the current character
        printSubsequences(str, idx + 1, newStr);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, 0, "");
    }
}