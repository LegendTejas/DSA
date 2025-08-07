package SortingAlgorithm;

public class SelectionSort {
	
	public static void main(String[] args) {
        int[] arr = {1, 4, 2, -5, 9, 7, 3, 2};
        
        // Outer loop: iterate over each element of the array (except the last one)
        for (int i = 0; i < arr.length-1; i++) {
            int min_val = i; // Assume the current index has the minimum value
            
            // Inner loop: find the index of the smallest element in the unsorted part
            for (int j = i+1; j < arr.length; j++) {
            	// If a smaller element is found, update min_val
                if (arr[min_val] > arr[j]) {
                    min_val = j;
                }
            }

            // Swap the smallest found element with the element at index i
            int temp = arr[min_val];
            arr[min_val] = arr[i];
            arr[i] = temp;
        }
        
        // Print the sorted array
        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
	}
} 