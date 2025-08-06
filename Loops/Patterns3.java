package Loops;

public class Patterns3 {
	public static void main(String args[]) {

//  Half pyramid with numbers
//	1 
//	1 2 
//	1 2 3 
//	1 2 3 4 
//	1 2 3 4 5 
		
	int n=5;
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=i; j++) {
			System.out.print(j+" ");
		}
		System.out.println();
	}
	
	System.out.println("\n");
	
//	inverted half pyramid with numbers
//	1 2 3 4 5 
//	1 2 3 4 
//	1 2 3 
//	1 2 
//	1 
	
	for(int i=n; i>=1;i--) {  // other way: for(int i=1; i<=n; i++)
		for(int j=1; j<=i;j++) { // other way: for(int j=1; j<=n-i+1; j++)
			System.out.print(j+" ");
		}
		System.out.println();
	}
  
  }

}