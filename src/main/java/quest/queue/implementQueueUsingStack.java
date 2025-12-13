package quest.queue;

import java.util.ArrayList;
import java.util.Stack;

public class implementQueueUsingStack {

}


class MyQueue {
    private Stack<Integer> stack_main;
    private Stack<Integer> stack_temp;

    public MyQueue() {
        stack_main = new Stack<>();
        stack_temp = new Stack<>();
    }

    public void push(int x) {
        stack_main.push(x);

    }

    public int pop() {
        if(stack_temp.isEmpty()) {
            while (!stack_main.isEmpty()) {
                stack_temp.push(stack_main.pop());
            }
        }
        return stack_temp.pop();
    }

    public int peek() {
        if(stack_temp.isEmpty()) {
            while (!stack_main.isEmpty()) {
                stack_temp.push(stack_main.pop());
            }
        }
        return stack_temp.peek();
    }

    public boolean empty() {
        return stack_main.isEmpty()&&stack_temp.isEmpty();
    }
}
