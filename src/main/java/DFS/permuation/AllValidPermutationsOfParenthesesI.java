package DFS.permuation;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int k) {
        List<String> res = new ArrayList<>();
        if (k <=0 ){
            return res;
        }
        helper(k, k, "", res );
        return res;
    }

    private void helper(int leftRem, int rightRem, String curRes, List<String> res) {
        if (leftRem == 0 && rightRem == 0) {
            res.add(curRes);
            return;
        }
        if (leftRem > 0 ) {
            helper(leftRem - 1, rightRem, curRes + "(", res);
        }
        if (rightRem > leftRem) {
            helper(leftRem, rightRem - 1, curRes + ")", res);
        }
    }
}
