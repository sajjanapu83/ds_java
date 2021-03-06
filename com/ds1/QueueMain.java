import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueMain {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(10);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(20);
        System.out.println(queue);

/*
        // Implementing queues with Stacks as data structure.
        // StackQueue queue = new StackQueue();
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.dequeue();
        // queue.enqueue(40);
        // queue.dequeue();
        // //queue.dequeue();
        // //queue.dequeue();
        // queue.print();
*/
/*
        // Implementing queues with Array are data structure.
        // ArrayQueue queue = new ArrayQueue(5);
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.enqueue(50);
        // queue.enqueue(60);
        // System.out.println(queue.isFull());
        // queue.print();
*/
   
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // // var value= queue.remove();
        // System.out.println(queue);
 
        // //reverseWithArray(queue);
        // reverseWithLinkedList(queue);

    }

    public static void reverseWithArray(Queue<Integer> inputQueue) {
        int[] temp = new int[inputQueue.size()];
        int i = inputQueue.size() - 1;

        while (!inputQueue.isEmpty()) {
            temp[i] = inputQueue.remove();
            i--;
        }

        for (int j = 0; j < temp.length; j++)
            System.out.println(temp[j]);
    }

    public static void reverseWithLinkedList(Queue<Integer> inputQueue) {
        // Stack newStack = new Stack(inputQueue.size());
        Stack<Integer> newStack = new Stack<>();

        while (!inputQueue.isEmpty()) {
            newStack.push(inputQueue.remove());
        }
        System.out.println(newStack.peek());
    }

}
