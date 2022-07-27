package stack;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {
//    s = "3[a]2[bc]", return "aaabcbc".
//    s = "3[a2[c]]", return "accaccacc".
//    s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
    public String decodeString(String input) {
        // Write your solution here
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()) {
            if(c == ']') {
                StringBuilder letters = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    letters.append(stack.pop());
                }
                letters.reverse();
                stack.pop();
                StringBuilder numberStr = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numberStr.append(stack.pop());
                }
                numberStr.reverse();
                int number = Integer.parseInt(numberStr.toString());
                for(int i = 1; i <= number; i++) {
                    for(char c1 : letters.toString().toCharArray()) {
                        stack.push(c1);
                    }
                    
                }
                continue;
            }
            stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }
}
