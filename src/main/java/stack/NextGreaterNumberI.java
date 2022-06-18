package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNumberI {
    public int[] nextGreaterElement(int[] partial, int[] all) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = all.length - 1; i >= 0; i--) {
            int cur = all[i];
            while (!stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(cur, -1);
            } else {
                map.put(cur, stack.peek());
            }
            stack.push(cur);
        }
        int[] result = new int[partial.length];
        for (int i = 0; i < partial.length; i++) {
            result[i] = map.get(partial[i]);
        }
        return result;
    }
}
