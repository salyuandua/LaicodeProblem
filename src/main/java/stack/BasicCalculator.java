package stack;

import java.util.Stack;

public class BasicCalculator {
    private int idx = 0;
    public int calculate(String input) {
        // Write your solution here

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        while(idx < input.length()) {
            char c = input.charAt(idx++);
            if(c == '(') {
                num = calculate(input);
            }
            if(Character.isDigit(c)) {
                num = num * 10 + Integer.valueOf("" + c);
            }
            if(idx == input.length() - 1 || c == '+' || c == '-' || c==')') {
                if(op == '+') {
                    stack.push(num);
                }else {
                    stack.push(-num);
                }
                num = 0;
                op = c;
            }
            if(c == ')') break;
        }

        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }
}
