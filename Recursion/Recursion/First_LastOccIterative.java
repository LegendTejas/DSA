// Print first and last occurance of an element in string (iterative method)

package Recursion;
import java.util.Scanner;

public class First_LastOccIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter the character to find: ");
        char element = sc.next().charAt(0);

        int first = str.indexOf(element), last = str.lastIndexOf(element);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        sc.close();
    }
}