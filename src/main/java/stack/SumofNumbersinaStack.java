package stack;

import java.util.Deque;

public class SumofNumbersinaStack {
    public int sumOfStack(Deque<Integer> stack) {
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
