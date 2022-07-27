package binaryTree;

import pojo.TreeNode;

public class SecondMinimumValueinBinaryTree {
    public int secondMinimumBT(TreeNode root) {
        // Write your solution here
        if(root == null) return -1;
        int res = helper(root, root.key);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(TreeNode root, int min) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.key > min) {
            return root.key;
        }
        int left = helper(root.left, min);
        int right = helper(root.right, min);
        return Math.min(left, right);
    }
}
