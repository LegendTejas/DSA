// Linked list from scratch for beginners

package LinkedList;

class LL {

    Node head; // Head node of the linked list
    private int size; // Tracks the size of the list

    // Constructor initializes size to 0
    LL() {
        size = 0;
    }

    // Node class to store data and reference to the next node
    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++; // Increment size whenever a new node is created
        }
    }

    // Add node at the beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) { // If list is empty
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }

    // Add node at a specific index (0-based index)
    public void addInMiddle(int index, String data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index value");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node currNode = head;

        for (int i = 1; i < index; i++) {
            currNode = currNode.next;
        }

        Node nextNode = currNode.next;
        currNode.next = newNode;
        newNode.next = nextNode;
    }

    // Print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Remove the first node
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        head = head.next;
        size--;
    }

    // Remove the last node
    public void removeLast() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }

        currNode.next = null;
    }

    // Remove a node at a specific index (0-based index)
    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index value");
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        size--;
        Node currNode = head;

        // Traverse to the node just before the index
        for (int i = 1; i < index; i++) {
            currNode = currNode.next;
        }

        // Bypass the node at index
        currNode.next = currNode.next.next;
    }

    // Reverse the linked list (iterative)
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    // Get the size of the linked list
    public int getSize() {
        return size;
    }

    // Main method (shows all operations step by step)
    public static void main(String[] args) {
        LL list = new LL();

        System.out.println("Adding elements at the end:");
        list.addLast("is");
        list.addLast("simple");
        list.addLast("list");
        list.addLast("Tejas");
        list.printList();

        System.out.println("\nAdding element at the beginning:");
        list.addFirst("This");
        list.addFirst("Tejas");
        list.printList();

        System.out.println("\nAdding element in the middle (index 2):");
        list.addInMiddle(3, "a");
        list.printList();

        System.out.println("\nCurrent size of list: " + list.getSize());

        System.out.println("\nRemoving first element:");
        list.removeFirst();
        list.printList();

        System.out.println("\nRemoving last element:");
        list.removeLast();
        list.printList();

        System.out.println("\nRemoving element at index 1:");
        list.removeAtIndex(2);  // Removes node at index 1
        list.printList();

        System.out.println("\nReversing the list:");
        list.reverseIterate();
        list.printList();

        System.out.println("\nFinal size of list: " + list.getSize());
    }
}