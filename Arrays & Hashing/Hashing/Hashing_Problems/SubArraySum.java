// Problem: Find total count of all subarrays with sum = k
// Example: Array = {10, 2, -2, -20, 10}, k = -10
// Expected Output: 3
package Hashing_Problems;

import java.util.*;

public class SubArraySum {
	
	public static void main(String[] args) {
		int arr[] = {10, 2, -2, -20, 10}; // ans = 3
		int k = -10;
		HashMap<Integer, Integer> map = new HashMap<>(); //<Sum, Frequency>
		
		map.put(0, 1); // empty subarray with key: 0, vlaue: 1
		int ans = 0;
		int sum = 0;
		for(int j=0; j<arr.length; j++) {
			sum += arr[j];
			
			if(map.containsKey(sum - k)) {
				ans += map.get(sum - k);
			}
			
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
		
		System.out.println("Total subarrays with sum = " + k + " : " + ans);
	}

}