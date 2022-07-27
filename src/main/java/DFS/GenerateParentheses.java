package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        helper(0, 0, n, "", res);
        return res;
    }

    private void helper(int left, int right, int n, String cur, List<String> res) {
        if(left > n || right > n) {
            return;
        }
        if(right > left) {
            return;
        }
        if(left == n && right == n) {
            res.add(cur);
            return;
        }
        helper(left + 1, right, n, cur + "(", res);
        helper(left, right + 1, n, cur + ")", res);
    }
}
