package hashing;

import java.util.*;

public class HashMapCode {
    public static void main(String args[]) {

        // Creation
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);
        System.out.println("Current Map: " + map + "\n");

        // Updating value
        System.out.println("Updating value of key 'China' from 150 → 180");
        map.put("China", 180);
        System.out.println("Map after update: " + map + "\n");

        // Searching
        if (map.containsKey("Indonesia")) {
            System.out.println("Key is present in the map");
        } else {
            System.out.println("Key is not present in the map");
        }

        System.out.println("\nValue for key 'China': " + map.get("China"));       // key exists
        System.out.println("Value for key 'Indonesia': " + map.get("Indonesia")); // key doesn't exist

        // Iteration (1): Using entrySet
        System.out.println("\nIterating using entrySet:");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Country: " + e.getKey() + " → Population: " + e.getValue());
        }
        System.out.println();

        // Iteration (2): Using keySet
        System.out.println("Iterating using keySet:");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Country: " + key + " → Population: " + map.get(key));
        }
        System.out.println();

        // Removing
        map.remove("China");
        System.out.println("Map after removing 'China': " + map);

    }
}