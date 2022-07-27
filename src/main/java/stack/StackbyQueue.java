package stack;

import java.util.LinkedList;

public class StackbyQueue {
    private LinkedList<Integer> data = new LinkedList<>();
        /** Initialize your data structure here. */
        public StackbyQueue() {
       
        }
    
        /** Push element x onto stack. */
        public void push(int x) {
            data.addLast(x);
        }
    
        /** Removes the element on top of the stack and returns that element. */
        public Integer pop() {
            if(data.isEmpty()) return null;
            return data.pollLast();
        }
    
        /** Get the top element. */
        public Integer top() {
            if(data.isEmpty()) return null;
            return data.getLast();
        }
    
        /** Returns whether the stack is empty. */
        public boolean isEmpty() {
           return data.isEmpty();
        }
}
