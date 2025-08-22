// Queue implementation using array (linear)
package queueDS;

public class QueueArray {
    static class Queue {
        int arr[];     // array to store queue elements
        int size;      // maximum size of queue
        int front;     // index of the front element
        int rear;      // index of the rear element

        // Constructor
        Queue(int size) {
            this.size = size;
            arr = new int[size];
            front = 0;   // front always starts at index 0
            rear = -1;   // queue is empty initially
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return rear == -1;
        }

        // Check if queue is full
        public boolean isFull() {
            return rear == size - 1;
        }

        // Enqueue: add element at the rear
        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue Overflow! Cannot enqueue " + data);
                return;
            }
            arr[++rear] = data; // increase rear and insert data
        }

        // Dequeue: remove element from the front (O(n) due to shifting)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow! Cannot dequeue");
                return -1;
            }
            int result = arr[front]; // store front element
            // shift all elements left by one position
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--; // decrease rear
            return result; // return dequeued element
        }

        // Peek: get the element at the front without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(4); // create a queue of size 4

        // Enqueue operations
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}