package LinkedList;

public class RecursiveReverse {
    
    // Node class to represent each element of the linked list
    static class Node {
        int data; 
        Node next;
        
        Node(int d) { 
            data = d; 
        }
    }

    // Utility function to print linked list in the format: node -> node -> null
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Recursive function to reverse the linked list
    static Node reverseListRecursive(Node head) {
        // Base case: if empty list or only one node, return head
        if (head == null || head.next == null) return head;
        
        // Reverse the rest of the list
        Node newHead = reverseListRecursive(head.next);
        
        // Make the next node point back to current node
        head.next.next = head;
        head.next = null;  // Break the original link
        return newHead;    // Return new head after reversal
    }

    public static void main(String[] args) {
        // Build list manually: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Print original linked list
        System.out.println("Original list:");
        printList(head);

        // Reverse linked list recursively
        head = reverseListRecursive(head);

        // Print reversed linked list
        System.out.println("\nReversed list (Recursive):");
        printList(head);
    }
}