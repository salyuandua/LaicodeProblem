package stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String input) {
        // Write your solution here
        boolean[] inStack = new boolean[26];
        int[] count = new int[26];
        for(char c : input.toCharArray()) {
            count[c]++;
        }

        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()) {
            if(inStack[c]) continue;
            while(!stack.isEmpty() && stack.peek() > c) {
                if(count[stack.peek()] == 0) break;
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
        
      }
}
