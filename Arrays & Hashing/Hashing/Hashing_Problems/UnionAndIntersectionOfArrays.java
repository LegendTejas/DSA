package Hashing_Problems;

import java.util.HashSet;

public class UnionAndIntersectionOfArrays {
    
    // Prints union array and returns its size
    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        
        // Insert elements of first array
        for(int num : arr1) {
            set.add(num);
        }
        
        // Insert elements of second array
        for(int num : arr2) {
            set.add(num);
        }
        
        // Print union array
        System.out.print("Union Array: ");
        for(int num : set) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        return set.size();
    }
    
    
    public static int intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();
        
        // Add all elements of arr1
        for(int num : arr1) {
            set1.add(num);
        }
        
        // Check which elements of arr2 are present in set1
        for(int num : arr2) {
            if(set1.contains(num)) {
                intersect.add(num);
            }
        }
        
        // Print intersection array
        System.out.print("Intersection Array: ");
        for(int num : intersect) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        return intersect.size();
    }
    
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        
        //print size of union and intersection array
        System.out.println("Size of Union: " + union(arr1, arr2));
        System.out.println("Size of Intersection: " + intersection(arr1, arr2));
    }
}