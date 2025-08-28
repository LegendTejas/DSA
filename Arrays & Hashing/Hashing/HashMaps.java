package hashing;

import java.util.*;

public class HashMaps {
    
    // Custom implementation of HashMap using Generics (K = Key, V = Value)
    static class HashMap<K, V> {
        
        // Node class to store key-value pairs
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Number of nodes (key-value pairs)
        private int N; // Number of buckets
        private LinkedList<Node> buckets[]; // Array of buckets (each bucket is a LinkedList)

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4; // Initial capacity
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function -> maps a key to a bucket index
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Searches for a key inside a linked list at bucket index 'bi'
        // Returns index of the key if found, else -1
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) { // key found
                    return i;
                }
            }
            return -1; // key not found
        }

        // Rehashing -> doubles the number of buckets when load factor exceeds threshold
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            
            // Initialize new bucket array
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // Reinsert old key-value pairs into new bucket array
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // Insert or update key-value pair
        public void put(K key, V value) {
            int bi = hashFunction(key);   // bucket index
            int di = searchInLL(key, bi); // data index in linked list

            if (di == -1) { // key doesn't exist -> insert new node
                buckets[bi].add(new Node(key, value));
                n++;
            } else { // key exists -> update value
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            // Load factor check
            double lambda = (double) n / N;
            if (lambda > 2.0) { // threshold for rehashing
                rehash();
            }
        }

        // Check if key exists in HashMap
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        // Remove key-value pair and return value
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) { // key doesn't exist
                return null;
            } else { // key exists -> remove it
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        // Get value associated with a key
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) { // key doesn't exist
                return null;
            } else { // key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // Return all keys stored in HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            
            for (int i = 0; i < buckets.length; i++) { // iterate through buckets
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) { // iterate through linked list
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Check if HashMap is empty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    // Driver code
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // Insertion
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        // Print all key-value pairs
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        // Remove operation
        map.remove("India");
        System.out.println("After removal, India -> " + map.get("India"));
    }
}