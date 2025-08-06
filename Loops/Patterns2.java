package Loops;
import java.util.Scanner;

public class Patterns2 {

	public static void main(String[] args) {
		
		// half pyramid
//		*
//		**
//		***
//		****
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		// inverted half pyramid
//		****
//		***
//		**
//		*
		for(int i = n; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		// inverted half pyramid (rotated by 180 deg)
//		    *
//		   **
//		  ***
//		 ****
		for(int i=1; i<=n; i++) {
			// inner loop 1: space print
			for(int j=1; j<=n-i;j++) {
				System.out.print(" ");
			}
			//inner loop 2: star print
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		sc.close();
	}

}