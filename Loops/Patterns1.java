package Loops;

public class Patterns1 {

	public static void main(String[] args) {
		// i rows and j columns
		
		// square or rectangle
//		*****
//		*****
//		*****
//		*****
		int n=4;
		int m=5;
		for (int i=1; i <= n; i++) { // rows = outer loop
			for (int j=1; j<=m; j++) { // columns = inner loop
				System.out.print("*");
			}
			System.out.println(); 
		}	
		
		System.out.println("\n");
		
		// hollow rectangle
//		*****
//		*   *
//		*   *
//		*****
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m;j++) {
				// cell -> (i,j)
				if (i==1 || j==1 || i==n || j==m) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	
	}

}