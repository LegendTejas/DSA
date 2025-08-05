package Recursion;

public class StrictlySortedArray {
	public static boolean isSorted(int arr[], int idx) {
		// Base Case: If we reach the last element, array is sorted
		if(idx == arr.length - 1) {
			return true; 
		}
		// If current element is less than the next one, continue checking
		if(arr[idx] < arr[idx + 1]) {
			//array is sorted till now
			return isSorted(arr, idx+1);
		} else {
			return false; // array is unsorted
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5};
		System.out.println(isSorted(arr, 0));
	}

}