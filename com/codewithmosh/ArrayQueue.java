

public class ArrayQueue {
    private int front;
    private int rear;
    private int[] queue;

    // 10, 20, 30 ,40 ,50
    // F R
    ArrayQueue(int size) {
        this.queue = new int[size];
    }

    // adding elements to queue
    public void enqueue(int item) {
        if (isFull())
            throw new IllegalArgumentException();
        queue[rear++] = item;
        // for circular queue
        /* 
        queu[rear] = item;
        rear = (rear +1) % queue.length 
        */
    }

    // Deleting elements from the queue
    public void dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException();
        queue[front++] = 0;
    }

    // For viewing the element without deleting
    public int peek() {
        if (front == queue.length)
            return -1;
        return queue[front];
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public boolean isFull() {
        return (rear == queue.length);
    }

    public void print() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }

}
