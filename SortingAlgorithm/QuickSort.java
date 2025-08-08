package SortingAlgorithm;

// Time Complexity: 
// Worst Case: O(n^2) Important: Worst case occurs when pivot is always the smallest or the largest element. 
// Average: O(n log n)

public class QuickSort {
	
	// This method partitions the array and returns the index of the pivot
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high]; // Choose the last element as the pivot
		int i = low - 1; // Pointer for elements smaller than the pivot
		
		// Traverse the array from low to high - 1
		for(int j=low; j<high; j++) {
			
			// If current element is smaller than pivot, swap it to correct position
			if(arr[j] < pivot) {
				i++;
				//Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j]; 
				arr[j] = temp;
			}
		}
		
		// Place the pivot at its correct sorted position
		i++;
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		return i; // Return the index of the pivot
	}
	
	// QuickSort function using recursion
	public static void quickSort(int arr[], int low, int high) {
		if(low < high) {
			// Get the pivot index after partition
			int pivot_idx = partition(arr, low, high);
			
			// Recursively sort elements before and after the pivot
			quickSort(arr, low, pivot_idx - 1);
			quickSort(arr, pivot_idx + 1, high);
		}
	}
	public static void main(String[] args) {
		int[] arr = {6,3,9,5,2,8};
		int n = arr.length;
		
		// Call quickSort on the full array
		quickSort(arr, 0, n-1);
		
		//print sorted array
		for(int num : arr) {
			System.out.print(num +" ");
		}
		System.out.println();
	}

}