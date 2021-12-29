package binaryTree.construct;

import pojo.ExpNode;

public class TernaryExpressionTree {
    public ExpNode tree(String exp) {
        // Write your solution here.
        int[] idxArray = new int[]{0};
        return helper(exp, idxArray);
    }

    private ExpNode helper(String exp, int[] idxArray) {
        int idx = idxArray[0];
        if (idx >= exp.length()) {
            return null;
        }
        char key = exp.charAt(idx++);
        ExpNode root = new ExpNode(key);
        if (idx >= exp.length()) {
            return root;
        }

        if (exp.charAt(idx) == ':') {
            idx++;
            idxArray[0] = idx;
            return root;
        }
        idx++;
        idxArray[0] = idx;
        root.left = helper(exp, idxArray);
        root.right = helper(exp, idxArray);
        return root;
    }


}
