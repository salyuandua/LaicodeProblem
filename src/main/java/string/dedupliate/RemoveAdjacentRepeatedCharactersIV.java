package string.dedupliate;

import java.util.Stack;

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        if (input == null || input.equals("")) return input;
        Stack<Character> stack = new Stack<>();
        char[] inputArray = input.toCharArray();
        int i = 0;
        while (i < inputArray.length) {
            if (stack.isEmpty() || stack.peek() != inputArray[i]) {
                stack.push(inputArray[i]);
                i++;
                continue;
            }
            while (i < inputArray.length && stack.peek() == inputArray[i]) {
                i++;
            }
            stack.pop();
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return  result.reverse().toString();
    }
}
