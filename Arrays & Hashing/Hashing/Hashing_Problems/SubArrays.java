// Problem: Find all subarrays with sum = k and print them along with the total count.
// Example: Array = {10, 2, -2, -20, 10}, k = -10
// Expected Output: 3 subarrays

package Hashing_Problems;

import java.util.*;

public class SubArrays {
	
	public static void main(String[] args) {
		int arr[] = {10, 2, -2, -20, 10}; 
		int k = -10;

		// Map to store prefixSum -> List of indices where this sum occurs
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		// Initialize with prefix sum = 0 at index -1 (before array starts)
		map.put(0, new ArrayList<>(Arrays.asList(-1)));

		int count = 0;   // total number of subarrays
		int sum = 0;     // prefix sum

		// Traverse array
		for(int j=0; j<arr.length; j++) {
			sum += arr[j]; // update prefix sum
			
			// If (sum - k) exists in map, then subarray(s) ending at j has sum = k
			if(map.containsKey(sum - k)) {
				List<Integer> startIndices = map.get(sum - k);
				
				// Print all subarrays that end at index j
				for(int start : startIndices) {
					count++;
					System.out.print("Subarray " + count + ": ");
					
					// Print elements of the subarray from start+1 to j
					for(int idx = start + 1; idx <= j; idx++) {
						System.out.print(arr[idx] + " ");
					}
					System.out.println();
				}
			}
			
			// Add current prefix sum to map
			if(!map.containsKey(sum)) {
				map.put(sum, new ArrayList<>());
			}
			map.get(sum).add(j);
		}

		System.out.println("\nTotal subarrays with sum = " + k + " : " + count);
	}
}