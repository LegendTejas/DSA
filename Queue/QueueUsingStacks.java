// Implement Queue using 2 Stacks
package queueDS;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation
    public void push(int x) {
        s1.push(x);
        System.out.println("Pushed: " + x);
    }

    // Dequeue operation
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        int val = s2.pop();
        System.out.println("Popped: " + val);
        return val;
    }

    // Peek front element
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        int val = s2.peek();
        System.out.println("Peeked: " + val);
        return val;
    }

    // Check if queue is empty
    public boolean empty() {
        boolean result = s1.isEmpty() && s2.isEmpty();
        System.out.println("Is Empty? " + result);
        return result;
    }

    // Main method to run in Eclipse
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        queue.peek();     // show 10
        queue.pop();      // remove 10
        queue.peek();     // show 20

        queue.pop();      // remove 20
        queue.pop();      // remove 30

        queue.empty();    // should return true
    }
}