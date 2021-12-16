package binaryTree.group1;

import pojo.TreeNode;

public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        return helper(one, two);
    }

    private boolean helper(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }else if(one == null || two == null) {
            return false;
        }else if(one.key != two.key) {
            return false;
        }
        return (helper(one.left, two.left) && helper(one.right, two.right)) ||
                (helper(one.left, two.right) && helper(one.right, two.left));
    }
}
