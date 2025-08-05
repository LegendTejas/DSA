// print all unique subsequence of string

package Recursion;
import java.util.*;

public class UniqueSubsequences {

    // Recursive function to generate all unique subsequences of a string
    public static void subsequences(String str, int idx, String newString, HashSet<String> set) {
        // Base Case: If we reach the end of the string
        if (idx == str.length()) {
            if (!set.contains(newString)) {
                System.out.println(newString);  // Print only unique subsequence
                set.add(newString);            // Add to set to track uniqueness
            }
            return;
        }

        char currChar = str.charAt(idx);

        // Include the current character in the new subsequence
        subsequences(str, idx + 1, newString + currChar, set);

        // Exclude the current character from the new subsequence
        subsequences(str, idx + 1, newString, set);
    }

    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        subsequences(str, 0, "", set);
    }
}