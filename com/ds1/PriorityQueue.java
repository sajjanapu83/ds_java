import java.util.Arrays;


public class PriorityQueue {
    private int[] queue;
    private int rear;

    public PriorityQueue(int size) {
        queue = new int[size];
    }

    public void insert(int value) {
        int i;
        if (rear == queue.length)
            throw new IllegalArgumentException();

        for (i = rear - 1; i >= 0; i--) {
            if (queue[i] > value) {
                queue[i + 1] = queue[i];
            } else {
                break;
            }
        }
        queue[i + 1] = value;
        rear++;
    }

    public int remove(){
        if (rear == 0)
            throw new IllegalStateException();
        
        return queue[--rear];        
    }

    public boolean isEmpty(){
        return (rear == 0);
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
