package Hashing_Problems;

import java.util.HashMap;

public class Iternary {

    // Function to find the starting point of the journey
    public static String getStart(HashMap<String, String> ticket) {
        // Reverse map stores destination -> source
        HashMap<String, String> reverseMap = new HashMap<>();

        // Fill reverse map
        for (String key : ticket.keySet()) {
            reverseMap.put(ticket.get(key), key);
        }

        // Find the starting point (a city that is never a destination)
        for (String key : ticket.keySet()) {
            if (!reverseMap.containsKey(key)) {
                return key;
            }
        }

        return null; // In case no start city is found
    }

    public static void main(String[] args) {
        // Map of tickets: Source -> Destination
        HashMap<String, String> tickets = new HashMap<>();
     // tickets.put(key, value);
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // Find starting city
        String start = getStart(tickets);

        // Print full itinerary
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start); // Move to next city
        }

        // Print last city
        System.out.println(start);
    }
}