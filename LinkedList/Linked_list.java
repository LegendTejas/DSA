package LinkedList;

import java.util.LinkedList;
import java.util.Collections;

public class Linked_list {

    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // 1. Adding elements at the end
        list.add("This");
        list.add("is");
        list.add("simple");
        list.add("list");
        list.add("Tejas");
        System.out.println("Adding elements at the end:");
        printList(list);

        // 2. Adding element at the beginning
        list.addFirst("Tejas");
        System.out.println("\nAdding element at the beginning:");
        printList(list);

        // 3. Adding element in the middle (index 2)
        list.add(3, "a");
        System.out.println("\nAdding element at index 3:");
        printList(list);

        // 4. Printing size
        System.out.println("\nCurrent size of list: " + list.size());

        // 5. Removing first element
        list.removeFirst();
        System.out.println("\nRemoving first element:");
        printList(list);

        // 6. Removing last element
        list.removeLast();
        System.out.println("\nRemoving last element:");
        printList(list);

        // 7. Removing element at index 1
        list.remove(2);
        System.out.println("\nRemoving element at index 2:");
        printList(list);

        // 8. Reversing the list
        Collections.reverse(list);
        System.out.println("\nReversing the list:");
        printList(list);

        // 9. Printing final size
        System.out.println("\nFinal size of list: " + list.size());
    }

    // Utility method to print LinkedList in "node -> node -> null" format
    private static void printList(LinkedList<String> list) {
        for (String item : list) {
            System.out.print(item + " -> ");
        }
        System.out.println("null");
    }
}