import java.util.Stack;

public class StackQueue {
    private int front;
    private int rear;
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    
    public void enqueue(int item){
        inStack.push(item);
    }
    public void dequeue(){
        if (outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            if (outStack.empty())
                throw new IllegalArgumentException();
            else
                outStack.pop();
        }
        else{
            if (outStack.empty())
                throw new IllegalArgumentException();
            else
                outStack.pop();
        }
    }
    //public int peek()
    //public boolean isEmpty()
    //public boolean isFull() 
    public void print(){
        while(!inStack.empty()){
            outStack.push(inStack.pop());
        }

        while(!outStack.empty()){
            System.out.println(outStack.pop());
        }
    }
}
