package Loops;

public class RhombusPattern {

	public static void main(String[] args) {
		
//    Solid Rhombus		
//    *****
//   *****
//  *****
// *****
//*****
		
		int n = 5;
		
		for(int i=1; i<=n; i++) {
			//print spaces (n-i spaces) 
			for(int j=1; j<=n-i; j++) {
				System.out.print(" ");
			}
			
			// print stars
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
}