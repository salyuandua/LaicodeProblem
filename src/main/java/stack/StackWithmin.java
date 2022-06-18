package stack;

import java.util.Stack;

public class StackWithmin {
    private Stack<Entry> stack = new Stack<>();

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop().value;
    }

    public void push(int element) {
        int min = element;
        if (!stack.isEmpty()) {
            min = Math.min(min, stack.peek().min);
        }
        stack.push(new Entry(element, min));
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().value;
    }

    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().min;
    }

    private static class Entry {
        int value;
        int min;

        public Entry(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
