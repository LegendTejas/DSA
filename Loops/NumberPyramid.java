package Loops;

public class NumberPyramid {

	public static void main(String[] args) {
		
//	     1 
//	    2 2 
//	   3 3 3 
//	  4 4 4 4 
//	 5 5 5 5 5 
		
		int n = 5;

       for(int i=1; i<=n; i++) {
           //spaces
           for(int j=1; j<=n-i; j++) {
               System.out.print(" ");
           }


           //numbers
           for(int j=1; j<=i; j++) {
               System.out.print(i+" ");
           }
           System.out.println();
       }
       
       System.out.println("\n");
       
//   2nd pattern
//        1
//       212
//      32123
//     4321234
//    543212345 
       for(int i=1; i<=n; i++) {
           //spaces
           for(int j=1; j<=n-i; j++) {
               System.out.print(" ");
           }


           //first part
           for(int j=i; j>=1; j--) {
               System.out.print(j);
           }


           //second part
           for(int j=2; j<=i; j++) {
               System.out.print(j);
           }
           System.out.println();
       }

       
	}

}