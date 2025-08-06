package Loops;

public class Patterns4 {

	public static void main(String[] args) {
		int n = 4; //number of rows
		int number = 1; //counter
		
//      Floyd's Triangle
//		1 
//		2 3 
//		4 5 6 
//		7 8 9 10 
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(number+" ");
				number++;
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
//		0 & 1 Triangle
//		1 
//		0 1 
//		1 0 1 
//		0 1 0 1 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i;j++) {
				if((i + j)%2 == 0) {
					System.out.print("1"+" ");
				}
				else {
					System.out.print("0"+" ");
				}
			}
			System.out.println();
		}
		
	}
}
