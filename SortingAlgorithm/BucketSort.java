package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static void bucketSort(float[] arr) {
		int n = arr.length;
		
        // buckets
        @SuppressWarnings("unchecked")
		ArrayList<Float>[] buckets = new ArrayList[n];
		//Create empty buckets
		for(int i=0; i<n; i++) {
			buckets[i] = new ArrayList<Float>();
		}
		
		//put array elements into the corresponding buckets
		for(int i=0; i<n; i++) {
			int bucketIndex = (int) arr[i]*n; // Index in bucket array
			buckets[bucketIndex].add(arr[i]);
		}
		
		//Sort each bucket individually
		for(int i=0; i < buckets.length; i++) {
			Collections.sort(buckets[i]);
		}
		
		//Concatenate all buckets to get final sorted array
		int index = 0;
		for(int i = 0; i < buckets.length; i++) {
			ArrayList<Float> currBucket = buckets[i];
			for(int j=0; j < currBucket.size(); j++) {
				arr[index++] = currBucket.get(j);
			}
		}
	}
	
	public static void main(String[] args) {
		float[] arr = {0.5f, 0.4f, 0.3f, 0.2f, 0.1f};
		bucketSort(arr);
		
		for(float num : arr) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
}

//Time Complexity

//Average Case: O(n+k) where k is the number of buckets (close to O(n) if elements are uniformly distributed).

//Worst Case: O(n^2) if all elements go into a single bucket.

//Best Case: O(n) when elements are perfectly uniformly distributed.