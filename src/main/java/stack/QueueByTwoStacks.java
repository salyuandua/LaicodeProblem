package stack;

import java.util.Stack;

public class QueueByTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public QueueByTwoStacks() {
        // Write your solution here.
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public void offer(int element) {
        stack1.push(element);
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int size() {
        return stack1.size();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
