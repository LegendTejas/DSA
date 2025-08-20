// Stack using Linked List

// Each element (Node) points to the next one, 
// and the stack operations happen only at the "head" (top of stack).

package stackDS;

public class StackLL {
    // Node class represents each element in the stack
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Stack class manages the linked list (LIFO operations)
    static class Stack {
        private Node head = null; // top of the stack, initially empty

        // Push operation: insert a new element at the top (head)
        public void push(int data) {
            Node newNode = new Node(data); // create a new node
            newNode.next = head;           // new node points to the current head
            head = newNode;                // update head to new node
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Pop operation: remove the top element and return its value
        public int pop() {
            if (isEmpty()) {
                return -1; // special value indicating stack is empty
            }
            int topData = head.data; // store the data of the top node
            head = head.next;        // move head to the next node
            return topData;          // return removed value
        }

        // Peek operation: return the top element without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // special value indicating stack is empty
            }
            return head.data; // return current top value
        }
    }

    // Driver code to test stack operations
    public static void main(String[] args) {
        Stack s = new Stack();

        // Push elements into stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // Print and pop elements until stack becomes empty
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // look at the top element
            s.pop();                      // remove the top element
        }
    }
}