package DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String input) {
        // Write your solution here
        int left = 0, right = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                if (left == 0){
                    right++;
                }else {
                    left--;
                }
            }
        }
        List<String> result = new ArrayList<>();
        helper(input, 0, left, right, "", result);
        return result;
    }

    private void helper(String input, int layer, int left, int right, String cur, List<String> result) {
        if (left == 0 && right == 0) {
            if (isValid(cur)) {
                result.add(cur);
            }
            return;
        }

        for (int i = layer; i < input.length(); i++) {
            if (i != layer && input.charAt(i) == input.charAt(i-1)) continue;
            char c = input.charAt(i);
            if (left > 0 && c == '(') {
                helper(input, layer + 1, left, right, cur + c, result);
                helper(input, layer + 1, left - 1, right, cur, result);
            }else if (right > 0 && c == ')') {
                helper(input, layer + 1, left , right, cur + c, result);
                helper(input, layer + 1, left , right - 1, cur, result);
            }else {
                helper(input, layer + 1, left , right, cur + c, result);
            }
        }

    }

    private boolean isValid(String cur) {
        int left = 0, right = 0;
        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
        }
        return left == right;
    }


}
