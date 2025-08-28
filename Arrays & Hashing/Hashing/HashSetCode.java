package hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetCode {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        // Add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // duplicate won't be added
        System.out.println("Current set: " + set + "\n");

        // Size
        System.out.println("Size of set: " + set.size() + "\n");

        // Search
        System.out.println("Searching for elements:");
        if (set.contains(1)) {
            System.out.println("Element 1 is present");
        }
        if (!set.contains(6)) {
            System.out.println("Element 6 is absent");
        }
        System.out.println();

        // Delete
        System.out.println("Deleting element 1...");
        set.remove(1);
        System.out.println("Current set after deletion: " + set);
        if (!set.contains(1)) {
            System.out.println("Element 1 is now absent\n");
        }

        // Print all elements
        System.out.println("Printing all elements directly: " + set + "\n");

        // Iteration - HashSet does not guarantee order
        System.out.println("Iterating over elements:");
        set.add(0); // adding one more element for iteration
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");

        // isEmpty
        if (!set.isEmpty()) {
            System.out.println("The set is not empty");
        } else {
            System.out.println("The set is empty");
        }
        System.out.println();
    }
}