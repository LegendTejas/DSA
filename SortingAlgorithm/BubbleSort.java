package SortingAlgorithm;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {7,8,1,3,2};
		
		//outer loop: controls the number of passes
		for(int i=0; i< arr.length - 1; i++) {
			
			//inner loop: compares adjacent elements and swaps them if needed
			for(int j=0; j < arr.length-i-1; j++) {
				
				// If the current element is greater than the next one, swap them
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		// method to print sorted array
        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
	}

}

// Time Complexity of Bubble Sort: O(n^2)