package string.decompress;

import java.util.Stack;

public class DecompressStringIII {
    public static String decodeStringIII(String input) {
        // Write your solution here
        if(input == null || input.length() == 0) return input;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ']') {
                stack.push(input.charAt(i));
                continue;
            }
            // ']'
            int count = 0;
            StringBuilder str = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                char c = stack.pop();
                if (Character.isDigit(c)) {
                    count = count * 10  + Character.getNumericValue(c);
                }else {
                    str.append(c);
                }
            }
            str.reverse();
            stack.pop();
            int bigCount = 0;
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                bigCount = bigCount * 10 + Character.getNumericValue(stack.pop());
            }
            if(count > 0) {
                String copyStr = str.toString();
                for(int j = 1; j < count; j++) {
                    str.append(copyStr);
                }
            }
            if(bigCount > 0) {
                String copyStr = str.toString();
                for(int j = 1; j < bigCount; j++) {
                    str.append(copyStr);
                }
            }
            for(char c : str.toString().toCharArray()) {
                stack.push(c);
            }

        }
        StringBuilder res = new StringBuilder();
        for (Character c : stack) {
                res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeStringIII("ab3[cd[2e]]f"));
    }
}
