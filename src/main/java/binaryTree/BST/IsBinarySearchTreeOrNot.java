package binaryTree.BST;

import pojo.TreeNode;

public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        return helper(root ,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return helper(root.left, min,  root.key) && helper(root.right, root.key, max);
    }
}
