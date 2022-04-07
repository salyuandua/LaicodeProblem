package string.decompress;

import java.util.Stack;

public class DecompressStringIII {
    public static String decodeStringIII(String input) {
        // Write your solution here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ']') {
                stack.push(input.charAt(i));
                continue;
            }
            int count = 0;
            StringBuilder str = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                char c = stack.pop();
                if (Character.isDigit(c)) {
                    count = Character.getNumericValue(c);
                }else {
                    str.append(c);
                }
            }
            stack.pop();
            if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                count = Character.getNumericValue(stack.pop());
            }
            String curStr = str.toString();
            str = new StringBuilder();
            for (int j = 0; j < count; j++) {
                str.append(curStr);
            }
            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
            }
        }
        stack.forEach(System.out::println);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decodeStringIII("ab3[cd[2e]]f"));
    }
}
