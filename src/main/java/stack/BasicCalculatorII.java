package stack;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String input) {
        // Write your solution here
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + Integer.parseInt("" + c);
            }
            if(i == input.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if(op == '+') {
                    stack.push(num);
                }else if(op == '-') {
                    stack.push(-num);
                }else if(op == '*') {
                    stack.push(stack.pop() * num);
                }else if(op == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = c;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }
}
