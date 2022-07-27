package stack;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if(!stack.isEmpty() && input.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, stack.isEmpty() ? i + 1 : i - stack.peek());
            }else{
                stack.push(i);
            }
        }
        return max;

    }
}
