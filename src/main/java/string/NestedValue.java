package string;

import java.util.Stack;

public class NestedValue {
    public static int value(String input) {
        // Write your solution here
        if (input == null || input.equals("")) return 0;
        int sum  = 0;
        int layer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{' ) {
                layer++;
                stack.push(c);
            }else if (c == '}') {
                int curSum = 0;
                while (!stack.isEmpty() && stack.peek() != '{') {
                    curSum += Character.getNumericValue(stack.pop());
                }
                sum += (curSum * layer);
                stack.pop();
                layer--;
            }else {
                stack.push(c);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(value("{34{5}6}"));
    }
}
