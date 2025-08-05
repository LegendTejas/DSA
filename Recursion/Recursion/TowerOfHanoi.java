package Recursion;
import java.util.Scanner;

public class TowerOfHanoi {
	public static void TOH(int n, String src, String helper, String destination) {
		// Base Case: If there is only one disk, move it from source to destination
		if (n == 1) {
			System.out.println("Move disk "+n+" from "+src+" to "+destination);
			return;
		}
		
		TOH(n-1, src, destination, helper); // move n-1 disk from src to helper using destination as buffer leaving first disk
		System.out.println("Move disk "+n+" from "+src+" to "+destination);
		
		TOH(n-1, helper, src, destination); // move n-1 disk from helper to destination using src as buffer
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = sc.nextInt();
		TOH(n, "S", "H", "D");
		
		sc.close();
		// Time Complexity: O(2^n)
	}
}