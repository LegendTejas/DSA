package SortingAlgorithm;
// Divide and Conquer aproach
// Time Complexity: O(n log n)

public class MergeSort {
	public static void divide(int arr[], int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = start + (end - start)/2;  // to avoid integer overflow we use this formula instead of this: (start + end)/2
		divide(arr, start, mid); // first half
		divide(arr, mid+1, end);
		conquer(arr, start, mid, end);
	}
	
	public static void conquer(int arr[], int start, int mid, int end) {
		int merged[] = new int[end - start + 1];
		
		int idx1 = start; // for first array
		int idx2 = mid+1; // for second array
		int x = 0; // for merged array
		
		while(idx1 <= mid && idx2 <= end) {
			if(arr[idx1] <= arr[idx2]) {
				merged[x++] = arr[idx1++];
			} else {
				merged[x++] = arr[idx2++];
			}
		}
		
		while(idx1 <= mid) {
			merged[x++] = arr[idx1++];
		}
		
		while(idx2 <= end) {
			merged[x++] = arr[idx2++];
		}
		
		for(int i=0; j=start; i<merged.length; i++; j++) {
			arr[j] = merged[i];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {6, 3, 9, 5, 2, 8};
		int n = arr.length;
		
		divide(arr, 0, n-1);
		
		for(int i=0; i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

