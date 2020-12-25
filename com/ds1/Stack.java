

import java.util.Arrays;

public class Stack {
    public int[] stack;
    private int count = 0;

    public Stack(int size) {
        stack = new int[size];
    }

    public void push(int item) {
        if (count ==  stack.length)
            throw new StackOverflowError();
        stack[count++] = item;            
    }
    public int pop(){
        if (count == 0)
            throw new StackOverflowError();
        return stack[--count];
    }
    public int peek(){
        if (count == 0)
            throw new IllegalArgumentException();
        return stack[count -1];
    }
    public boolean isEmpty(){
        return (count == 0);
    }
    @Override
    public String toString(){
        return Arrays.toString(stack);
    }

}
