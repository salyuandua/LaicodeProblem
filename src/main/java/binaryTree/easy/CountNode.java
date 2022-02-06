package binaryTree.easy;

import pojo.TreeNode;

public class CountNode {
    public int countNodes(TreeNode root) {
        // Write your solution here
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private void helper(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }
        count[0] ++;
        helper(root.left, count);
        helper(root.right, count);
    }
}
