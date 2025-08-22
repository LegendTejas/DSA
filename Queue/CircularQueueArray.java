package queueDS;

public class CircularQueueArray {
    static class Queue {
        private int[] arr;    // array to store queue elements
        private int size;     // maximum size of the queue
        private int front;    // points to front element
        private int rear;     // points to last element

        Queue(int size) {
            this.size = size;
            arr = new int[size];
            front = -1;
            rear = -1;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // Check if queue is full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Enqueue operation (insert element at rear)
        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            if (isEmpty()) {
                front = 0;   // first element
            }
            rear = (rear + 1) % size; // circular increment
            arr[rear] = data;
        }

        // Dequeue operation (remove element from front)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            
            if (front == rear) { // only one element left
                front = rear = -1;
            } else {
                front = (front + 1) % size; // circular increment
            }
            return result;
        }

        // Peek operation (get front element)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
    	Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        q.dequeue(); // remove top element
        
        while(!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
 }