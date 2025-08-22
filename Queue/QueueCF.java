//queue using Java Collection Framework
package queueDS;

import java.util.*;

public class QueueCF {
 public static void main(String args[]) {
     Queue<Integer> q = new ArrayDeque<>(); // Create a queue of integers using ArrayDeque (FIFO order)
     
     // Note we can also use LinkedList instead of ArrayDeque to create a queue
     // Queue<Integer> q = new LinkedList<>();
     
     q.add(1);
     q.add(2);
     q.add(3);
     q.add(4);

     while(!q.isEmpty()) {
         System.out.println(q.peek());
         q.remove();
     }
 }
}