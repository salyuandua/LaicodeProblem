package DFS.permuation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllValidPermutationsOfParenthesesII {
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        helper(l, l, m, m, n, n, "", res, new Stack<>());
        return res;
    }

    private void helper(int lleft, int lright, int mleft, int mright,
                        int nleft, int nright, String cur, List<String> res, Stack<String> stack) {
        if (lleft == 0 && lright == 0 && mleft == 0 && mright == 0 &&
             nleft == 0 && nright == 0) {
            res.add(cur);
            return;
        }
        if (lleft > 0) {
            stack.push("(");
            helper(lleft - 1, lright, mleft, mright, nleft, nright, cur + "(", res, stack);
            stack.pop();
        }
        if (mleft > 0) {
            stack.push("<");
            helper(lleft, lright, mleft - 1, mright, nleft, nright, cur + "<", res, stack);
            stack.pop();
        }
        if (nleft > 0) {
            stack.push("{");
            helper(lleft, lright, mleft, mright, nleft - 1, nright, cur + "{", res, stack);
            stack.pop();
        }
        if (lright > lleft && !stack.isEmpty() && stack.peek().equals("(")) {
            stack.pop();
            helper(lleft, lright - 1, mleft, mright, nleft, nright, cur + ")", res, stack);
            stack.push("(");
        }

        if (mright > mleft && !stack.isEmpty() && stack.peek().equals("<")) {
            stack.pop();
            helper(lleft, lright, mleft, mright - 1, nleft, nright, cur + ">", res, stack);
            stack.push("<");
        }

        if (nright > nleft && !stack.isEmpty() && stack.peek().equals("{")) {
            stack.pop();
            helper(lleft, lright, mleft, mright, nleft, nright - 1, cur + "}", res, stack);
            stack.push("{");
        }
    }
}
