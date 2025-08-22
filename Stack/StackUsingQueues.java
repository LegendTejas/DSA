// Implement Stack using 2 Queues
package stackDS;

import java.util.*;

public class StackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    // Push element onto stack
    public void push(int x) {
        q1.add(x); 
        System.out.println("Pushed: " + x);
    }

    // Pop element from stack
    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.remove()); 
        }
        int top = q1.remove(); 
        System.out.println("Popped: " + top);

        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Get top element
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove()); 
        }
        int top = q1.remove(); 
        q2.add(top); // put back since it's just a peek
        System.out.println("Top element: " + top);

        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Check if stack is empty
    public boolean empty() {
        boolean result = q1.isEmpty();
        System.out.println("Is Empty? " + result);
        return result;
    }

    // Main method for testing in Eclipse
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.top();     // show 30
        stack.pop();     // remove 30
        stack.top();     // show 20

        stack.pop();     // remove 20
        stack.pop();     // remove 10

        stack.empty();   // return true
    }
}