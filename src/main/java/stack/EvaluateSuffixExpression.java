package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateSuffixExpression {
    public static int evaluate(String[] suffix) {
        // Write your solution here
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList("+", "-", "*", "/"));
        for (int i = 0; i < suffix.length; i++) {
            String s = suffix[i];
            if (set.contains(s)) {
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(n2 + n1));
                }else if (s.equals("-")) {
                    stack.push(String.valueOf(n2 - n1));
                }else if (s.equals("*")) {
                    stack.push(String.valueOf(n2 * n1));
                }else {
                    stack.push(String.valueOf(n2 / n1));
                }
                continue;
            }
            stack.push(s);

        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{"2", "12", "4", "+", "*"}));
    }

}
