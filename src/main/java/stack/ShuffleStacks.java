package stack;

import java.util.Deque;

public class ShuffleStacks {
    public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
