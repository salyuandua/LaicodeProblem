package stack;

import java.util.Stack;

public class NestedListWeightSum {
    public static int depthSum(String nestlists) {
        // Write your solution here
        Stack<String> stack = new Stack<>();
        int layer = 0;
        int result = 0;
        int i = 0;
        while (i < nestlists.length()) {
            char c = nestlists.charAt(i);
            if (c == '[') {
                stack.push(c + "");
                layer++;
            }else if (c == ']') {
                int sum = 0;
                String prev = null;
                while (!"[".equals(prev = stack.pop())) {
                    sum += Integer.parseInt(prev);
                }
                sum = sum * layer;
                result += sum;
                layer--;
            }else if (Character.isDigit(c) || c == '-'){
                StringBuilder number = new StringBuilder();
                while (Character.isDigit(c)|| c == '-') {
                    number.append(c);
                    i++;
                    c = nestlists.charAt(i);
                }
                stack.push(""+Integer.parseInt(number.toString()));
                continue;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(depthSum("[-1]"));
    }

}
