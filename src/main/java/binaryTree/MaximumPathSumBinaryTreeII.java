package binaryTree;

import pojo.TreeNode;

public class MaximumPathSumBinaryTreeII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        if (root == null) {
            return max[0];
        }
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left, max));
        int right = Math.max(0, helper(root.right, max));
        int sum = root.key + left + right;
        max[0] = Math.max(max[0], sum);
        return Math.max(left, right) + root.key;
    }
}
