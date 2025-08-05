package Recursion;

// Print x^n (with stack height = n)

public class XpowerN_1 {
	public static int Power(int x, int n) {
		if(n==0) {
			return 1;
		}
		if(x==0) {
			return 0;
		}
		int xn = x * Power(x, n-1);
		return xn;		
	}
	
	public static void main(String[] args) {
		int x = 3, n = 4;
		int output = Power(x, n); // 3^4
		System.out.println(output);
		
		
	}

}
