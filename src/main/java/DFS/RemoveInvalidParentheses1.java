package DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses1 {
    public List<String> removeInvalidParentheses(String input) {
        int left = 0;
        int right = 0;
        for(char c : input.toCharArray()) {
            if(c == '(') left++;
            if(c == ')') {
                if(left == 0) {
                    right++;
                }else{
                    left--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        helper(input, 0, left, right, res);
        return res;
    }

    private void helper(String input, int layer, int left, int right, List<String> res) {
        if(left == 0 && right == 0) {
            if(isValid(input)) res.add(input);
            return;
        }

        for(int i = layer; i < input.length(); i++) {
            if(i > layer && input.charAt(i) == input.charAt(i - 1)) continue;
            char cur = input.charAt(i);
            if(cur == '(' || cur == ')') {
                StringBuilder sb = new StringBuilder(input);
                sb.deleteCharAt(i);
                if(right > 0 && cur == ')') {
                    helper(sb.toString(), i, left, right - 1, res);
                }else if(left > 0 && cur == '(') {
                    helper(sb.toString(), i, left - 1, right, res);
                }

            }
        }
    }

    private boolean isValid(String input) {
        int left = 0;
        int right = 0;
        for(char c : input.toCharArray()) {
            if(c == '(') {
                left++;
            }
            if(c == ')') {
                right++;
            }
            if(right > left) return false;
        }
        return left == right;
    }
}
