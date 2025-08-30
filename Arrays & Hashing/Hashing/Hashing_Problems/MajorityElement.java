package Hashing_Problems;

import java.util.*;

public class MajorityElement {
    
    // Function to find elements that appear more than n/3 times
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        // Count frequency of each element
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) { 
                // If element already exists in map, increment its count
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // Otherwise, add the element with initial count = 1
                map.put(nums[i], 1);
            }
        }
        
        // Traverse the map to find elements occurring more than n/3 times
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        majorityElement(nums); 
    }
}